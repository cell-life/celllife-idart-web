package org.celllife.idart.application.dispensation

import org.celllife.idart.application.dispensation.dto.DispensationDto
import org.celllife.idart.application.dispensation.dto.DispensationDtoAssembler
import org.celllife.idart.common.DispensationId
import org.celllife.idart.common.Identifier
import org.celllife.idart.common.PersonId;
import org.celllife.idart.common.PrescriptionId;
import org.celllife.idart.common.SystemId
import org.celllife.idart.domain.dispensation.DispensationNotFoundException
import org.celllife.idart.domain.dispensation.DispensationService
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.relationship.systemfacility.SystemFacilityService

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

import static org.celllife.idart.common.DispensationId.dispensationId
import static org.celllife.idart.common.IdentifiableType.DISPENSATION
import static org.celllife.idart.common.IdentifiableType.FACILITY
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.newIdentifiers
import static org.celllife.idart.common.DispensationId.dispensationId
import static org.celllife.idart.common.Systems.IDART_WEB
import static org.celllife.idart.common.Systems.PREHMIS
import static org.celllife.idart.relationship.facilityorganisation.FacilityOrganisation.Relationship.OPERATED_BY
import static org.celllife.idart.relationship.patientorganisation.PatientOrganisation.Relationship.REGISTERED_WITH
import static org.celllife.idart.relationship.systemfacility.SystemFacility.Relationship.DEPLOYED_AT

/**
 */
@Named class DispensationApplicationServiceImpl implements DispensationApplicationService {

    @Inject DispensationService dispensationService

    @Inject DispensationDtoAssembler dispensationDtoAssembler

    @Inject IdentifiableService identifiableService

    @Inject SystemFacilityService systemFacilityService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(DispensationId dispensationId) {
        dispensationService.exists(dispensationId)
    }

    @Override
    @Transactional
    DispensationId save(SystemId system, DispensationDto dispensationDto) {

        def facility = systemFacilityService.findFacility(system, DEPLOYED_AT)

        dispensationDto.facility << newIdentifier(facility.value)

        save(dispensationDto)
    }

    @Override
    @Transactional
    DispensationId save(DispensationDto dispensationDto) {

        def identifiable = identifiableService.resolveIdentifiable(DISPENSATION, dispensationDto.identifiers)
        dispensationDto.identifiers = identifiable.identifiers

        def dispensationId = dispensationId(identifiable.getIdentifierValue(IDART_WEB.id))

        def dispensation = dispensationDtoAssembler.toDispensation(dispensationDto)
        dispensation.id = dispensationId

        dispensationService.save(dispensation)

        dispensation.id
    }

    @Override
    @Transactional(readOnly = true)
    DispensationDto findByDispensationId(DispensationId dispensationId) {
        def identifier = newIdentifier(dispensationId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    DispensationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(DISPENSATION, [identifier] as Set)
        if (identifiable == null) {
            throw new DispensationNotFoundException("Could not find Dispensation with id [${identifier}]")
        }

        def dispensationId = dispensationId(identifiable.getIdentifierValue(IDART_WEB.id))

        def dispensation = dispensationService.findByDispensationId(dispensationId)

        def dispensationDto = dispensationDtoAssembler.toDispensationDto(dispensation)
        dispensationDto.identifiers = identifiable.identifiers

        dispensationDto
    }

    @Override
    @Transactional(readOnly = true)
    DispensationId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(DISPENSATION, identifiers)
        if (identifiable == null) {
            throw new DispensationNotFoundException("Could not find Dispensation with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        dispensationId(idartIdentifierValue)
    }

    @Override
    @Transactional
    void deleteByDispensationId(DispensationId dispensationId) {
        dispensationService.deleteByDispensationId(dispensationId)
    }

    @Override
    @Transactional
    void deleteByIdentifierAndSystem(String identifier, SystemId system) {

        // get the information about the facility
        def facility = systemFacilityService.findFacility(system, DEPLOYED_AT)
        def facilityIdentifiable = identifiableService.resolveIdentifiable(FACILITY, newIdentifiers(IDART_WEB.id, facility.value))

        def patients = facilityIdentifiable.identifiers.collect() { facilityIdentifier ->

            // convert the specified dispensation id to an iDARTweb id
            def identifiable = identifiableService.findByIdentifiers(DISPENSATION, newIdentifiers(system, identifier))
            if (facilityIdentifiable == null) {
                throw new DispensationNotFoundException("Could not find Dispensation with id [${system} - ${identifier}]")
            }
    
            def idartwebId = identifiable.getIdentifierValue(IDART_WEB.id)
            
            switch (facilityIdentifier.system) {
                case PREHMIS.id:
                    dispensationService.deleteByDispensationId(DispensationId.dispensationId(idartwebId))
            }
        }
    }

    @Override
    @Transactional
    void deleteByIdentifierAndPerson(String identifier, PersonId personId) {
        // no implementation for online system yet
        
    }
}
