package org.celllife.idart.application.prescribedmedication

import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDto
import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDtoAssembler
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationNotFoundException
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationService

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PrescribedMedicationId.prescribedMedicationId
import static org.celllife.idart.common.IdentifiableType.PRESCRIBED_MEDICATION
import static org.celllife.idart.common.Identifiers.newIdentifier
import static org.celllife.idart.common.Identifiers.getIdentifierValue

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescribedMedicationApplicationServiceImpl implements PrescribedMedicationApplicationService {

    @Inject PrescribedMedicationService prescribedMedicationService   

    @Inject PrescribedMedicationDtoAssembler prescribedMedicationDtoAssembler

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(PrescribedMedicationId prescribedMedicationId) {
        prescribedMedicationService.exists(prescribedMedicationId)
    }

    @Override
    PrescribedMedicationId save(PrescribedMedicationDto prescribedMedicationDto) {

        def identifiable = identifiableService.resolveIdentifiable(PRESCRIBED_MEDICATION, prescribedMedicationDto.identifiers)

        def prescribedMedicationId = prescribedMedicationId(identifiable.getIdentifierValue(IDART))

        def prescribedMedication = prescribedMedicationDtoAssembler.toPrescribedMedication(prescribedMedicationDto)
        prescribedMedication.id = prescribedMedicationId

        prescribedMedicationService.save(prescribedMedication)

        prescribedMedication.id
    }

    @Override
    PrescribedMedicationDto findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) {
        def identifier = newIdentifier(IDART, prescribedMedicationId.value)
        findByIdentifier(identifier)
    }

    @Override
    PrescribedMedicationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(PRESCRIBED_MEDICATION, [identifier] as Set)

        if (identifiable == null) {
            throw new PrescribedMedicationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def prescribedMedicationId = prescribedMedicationId(identifiable.getIdentifierValue(IDART))

        def prescribedMedication = prescribedMedicationService.findByPrescribedMedicationId(prescribedMedicationId)

        def prescribedMedicationDto = prescribedMedicationDtoAssembler.toPrescribedMedicationDto(prescribedMedication)
        prescribedMedicationDto.identifiers = identifiable.identifiers

        prescribedMedicationDto
    }

    @Override
    PrescribedMedicationId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(PRESCRIBED_MEDICATION, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        prescribedMedicationId(idartIdentifierValue)
    }
}
