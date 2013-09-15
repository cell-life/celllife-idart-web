package org.celllife.idart.application.prescription

import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.domain.identifiable.Identifiable
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.domain.identifiable.Identifier
import org.celllife.idart.domain.prescription.PrescriptionNotFoundException
import org.celllife.idart.domain.prescription.PrescriptionService

import static org.celllife.idart.application.prescription.dto.PrescriptionDtoAssembler.toPrescription
import static org.celllife.idart.application.prescription.dto.PrescriptionDtoAssembler.toPrescriptionDto
import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.PrescriptionId.prescriptionId
import static org.celllife.idart.domain.identifiable.IdentifiableType.PRESCRIPTION
import static org.celllife.idart.domain.identifiable.Identifiers.newIdentifier

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class PrescriptionApplicationServiceImpl implements PrescriptionApplicationService {

    @Inject PrescriptionService prescriptionService   

    @Inject IdentifiableService identifiableService

    @Override
    Boolean exists(PrescriptionId prescriptionId) {
        prescriptionService.exists(prescriptionId)
    }

    PrescriptionId save(PrescriptionDto prescriptionDto) {

        def prescription = toPrescription(prescriptionDto)

        def identifiable = identifiableService.findByIdentifiers(PRESCRIPTION, prescriptionDto.identifiers)
        if (identifiable == null) {

            prescription = prescriptionService.save(prescription)

            identifiable = new Identifiable(type: PRESCRIPTION, identifiers: prescriptionDto.identifiers)
            identifiable.addIdentifier(newIdentifier(IDART, prescription.id.value))
            identifiableService.save(identifiable)

        } else {

            prescription.id = prescriptionId(identifiable.getIdentifier(IDART).value)
            prescriptionService.save(prescription)

        }

        prescription.id
    }

    @Override
    PrescriptionDto findByPrescriptionId(PrescriptionId prescriptionId) {
        def identifier = newIdentifier(IDART, prescriptionId.value)
        findByIdentifier(identifier)
    }

    @Override
    PrescriptionDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.findByIdentifiers(PRESCRIPTION, [identifier] as Set)

        if (identifiable == null) {
            throw new PrescriptionNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def prescriptionId = prescriptionId(identifiable.getIdentifier(IDART).value)

        def prescription = prescriptionService.findByPrescriptionId(prescriptionId)

        def prescriptionDto = toPrescriptionDto(prescription)
        prescriptionDto.identifiers = identifiable.identifiers

        prescriptionDto
    }
}
