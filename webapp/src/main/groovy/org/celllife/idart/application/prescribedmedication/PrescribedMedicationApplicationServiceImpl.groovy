package org.celllife.idart.application.prescribedmedication

import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDto
import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDtoAssembler
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationNotFoundException
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationService

import static org.celllife.idart.common.PrescribedMedicationId.prescribedMedicationId
import static org.celllife.idart.common.IdentifiableType.PRESCRIBED_MEDICATION
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Systems.IDART_WEB

import javax.inject.Inject
import javax.inject.Named

import org.springframework.transaction.annotation.Transactional

/**
 */
@Named class PrescribedMedicationApplicationServiceImpl implements PrescribedMedicationApplicationService {

    @Inject PrescribedMedicationService prescribedMedicationService   

    @Inject PrescribedMedicationDtoAssembler prescribedMedicationDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    @Transactional(readOnly = true)
    Boolean exists(PrescribedMedicationId prescribedMedicationId) {
        prescribedMedicationService.exists(prescribedMedicationId)
    }

    @Override
    @Transactional
    PrescribedMedicationId save(PrescribedMedicationDto prescribedMedicationDto) {

        def identifiable = identifiableService.resolveIdentifiable(PRESCRIBED_MEDICATION, prescribedMedicationDto.identifiers)
        prescribedMedicationDto.identifiers = identifiable.identifiers

        def prescribedMedicationId = prescribedMedicationId(identifiable.getIdentifierValue(IDART_WEB.id))

        def prescribedMedication = prescribedMedicationDtoAssembler.toPrescribedMedication(prescribedMedicationDto)
        prescribedMedication.id = prescribedMedicationId

        prescribedMedicationService.save(prescribedMedication)

        prescribedMedication.id
    }

    @Override
    @Transactional(readOnly = true)
    PrescribedMedicationDto findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) {
        def identifier = newIdentifier(prescribedMedicationId.value)
        findByIdentifier(identifier)
    }

    @Override
    @Transactional(readOnly = true)
    PrescribedMedicationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PRESCRIBED_MEDICATION, [identifier] as Set)
        if (identifiable == null) {
            throw new PrescribedMedicationNotFoundException("Could not find PrescribedMedication with id [${identifier}]")
        }

        def prescribedMedicationId = prescribedMedicationId(identifiable.getIdentifierValue(IDART_WEB.id))

        def prescribedMedication = prescribedMedicationService.findByPrescribedMedicationId(prescribedMedicationId)

        def prescribedMedicationDto = prescribedMedicationDtoAssembler.toPrescribedMedicationDto(prescribedMedication)
        prescribedMedicationDto.identifiers = identifiable.identifiers

        prescribedMedicationDto
    }

    @Override
    @Transactional(readOnly = true)
    PrescribedMedicationId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.findByIdentifiers(PRESCRIBED_MEDICATION, identifiers)
        if (identifiable == null) {
            throw new PrescribedMedicationNotFoundException("Could not find PrescribedMedication with id [${identifiers}]")
        }

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART_WEB.id)

        prescribedMedicationId(idartIdentifierValue)
    }
}