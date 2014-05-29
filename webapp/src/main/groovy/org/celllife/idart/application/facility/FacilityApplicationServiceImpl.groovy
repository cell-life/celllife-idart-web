package org.celllife.idart.application.facility

import static org.celllife.idart.common.FacilityId.facilityId
import static org.celllife.idart.common.IdentifiableType.FACILITY
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

import org.celllife.idart.application.facility.dto.FacilityDto
import org.celllife.idart.application.facility.dto.FacilityDtoAssembler
import org.celllife.idart.common.FacilityId
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.facility.Facility
import org.celllife.idart.domain.facility.FacilityNotFoundException
import org.celllife.idart.domain.facility.FacilityService
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class FacilityApplicationServiceImpl implements FacilityApplicationService {
    
    static final Logger LOGGER = LoggerFactory.getLogger(FacilityApplicationServiceImpl)

    @Inject FacilityService facilityService   

    @Inject FacilityDtoAssembler facilityDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(FacilityId facilityId) {
        facilityService.exists(facilityId)
    }

    @Override
    @Transactional
    FacilityId save(FacilityDto facilityDto) {

        def identifiable = identifiableService.resolveIdentifiable(FACILITY, facilityDto.identifiers)
        facilityDto.identifiers = identifiable.identifiers

        def facilityId = facilityId(identifiable.getIdentifierValue(IDART_WEB.id))

        def facility = facilityDtoAssembler.toFacility(facilityDto)
        facility.id = facilityId

        facilityService.save(facility)

        facility.id
    }

    @Override
    @Transactional(readOnly = true)
    FacilityDto findByFacilityId(FacilityId facilityId) {
        def identifier = newIdentifier(facilityId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    FacilityDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(FACILITY, [identifier] as Set)
        if (identifiable == null) {
            throw new FacilityNotFoundException("Could not find Facility with id [${identifier}]")
        }

        def facilityId = facilityId(identifiable.getIdentifierValue(IDART_WEB.id))

        def facility = facilityService.findByFacilityId(facilityId)

        def facilityDto = facilityDtoAssembler.toFacilityDto(facility)
        facilityDto.identifiers = identifiable.identifiers

        facilityDto
    }

    @Override
    @Transactional(readOnly = true)
    FacilityId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(FACILITY, identifiers)
        if (identifiable == null) {
            throw new FacilityNotFoundException("Could not find Facility with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        facilityId(idartIdentifierValue)
    }

    @Override
    @Transactional(readOnly = true)
    List<FacilityDto> findAll() {
        List<FacilityDto> allDtos = new ArrayList<FacilityDto>();
        List<Facility> all = facilityService.findAll()
        for (Facility f : all) {
            FacilityDto dto = facilityDtoAssembler.toFacilityDto(f)
            Identifier identifier = newIdentifier(f.getId().value) // have to set the identifier separately (?)
            dto.setIdentifiers([identifier] as Set)
            allDtos.add(dto)
        }
        return allDtos
    }
}