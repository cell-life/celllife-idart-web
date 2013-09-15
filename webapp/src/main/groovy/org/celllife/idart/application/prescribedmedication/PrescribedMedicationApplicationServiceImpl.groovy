package org.celllife.idart.application.prescribedmedication

import org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDto
import org.celllife.idart.common.PrescribedMedicationId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationNotFoundException
import org.celllife.idart.domain.prescribedmedication.PrescribedMedicationService

import static org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDtoAssembler.toPrescribedMedication
import static org.celllife.idart.application.prescribedmedication.dto.PrescribedMedicationDtoAssembler.toPrescribedMedicationDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PrescribedMedicationId.prescribedMedicationId
import static org.celllife.idart.domain.identifiable.IdentifiableType.PRESCRIBED_MEDICATION
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescribedMedicationApplicationServiceImpl implements PrescribedMedicationApplicationService {

    @Inject PrescribedMedicationService prescribedMedicationService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(PrescribedMedicationId prescribedMedicationId) {
        prescribedMedicationService.exists(prescribedMedicationId)
    }

    PrescribedMedicationId save(PrescribedMedicationDto prescribedMedicationDto) {

        def prescribedMedication = toPrescribedMedication(prescribedMedicationDto)

        def identifiable = identifiableService.findByIdentifiers(PRESCRIBED_MEDICATION, prescribedMedicationDto.identifiers)
        if (identifiable == null) {

            prescribedMedication = prescribedMedicationService.save(prescribedMedication)

            identifiable = new Identifiable(type: PRESCRIBED_MEDICATION, identifiers: prescribedMedicationDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, prescribedMedication.id.value))
            identifiableService.save(identifiable)

        } else {

            prescribedMedication.id = prescribedMedicationId(identifiable.getIdentifier(IDART).value)
            prescribedMedicationService.save(prescribedMedication)

        }

        prescribedMedication.id
    }

    @Override
    PrescribedMedicationDto findByPrescribedMedicationId(PrescribedMedicationId prescribedMedicationId) {
        def identifier = newIdentifier(IDART, prescribedMedicationId.value)
        findByIdentifier(identifier)
    }

    @Override
    PrescribedMedicationDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PRESCRIBED_MEDICATION, [identifier] as Set)

        if (identifiable == null) {
            throw new PrescribedMedicationNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def prescribedMedicationId = prescribedMedicationId(identifiable.getIdentifier(IDART).value)

        def prescribedMedication = prescribedMedicationService.findByPrescribedMedicationId(prescribedMedicationId)

        def prescribedMedicationDto = toPrescribedMedicationDto(prescribedMedication)
        prescribedMedicationDto.identifiers = identifiable.identifiers

        prescribedMedicationDto
    }
}
