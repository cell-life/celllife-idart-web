package org.celllife.idart.application.prescription

import org.celllife.idart.application.prescribedmedication.PrescribedMedicationApplicationService
import org.celllife.idart.application.prescription.dto.PrescriptionDto
import org.celllife.idart.application.prescription.dto.PrescriptionDtoAssembler
import org.celllife.idart.common.PrescriptionId
import org.celllife.idart.domain.encounter.EncounterService
import org.celllife.idart.domain.identifiable.IdentifiableService
import org.celllife.idart.common.Identifier
import org.celllife.idart.domain.prescription.PrescriptionNotFoundException
import org.celllife.idart.domain.prescription.PrescriptionService

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.common.AuthorityId.IDART
import static org.celllife.idart.common.AuthorityId.PREHMIS
import static org.celllife.idart.common.EncounterId.encounterId
import static org.celllife.idart.common.PrescriptionId.prescriptionId
import static org.celllife.idart.common.IdentifiableType.FACILITY
import static org.celllife.idart.common.IdentifiableType.PRESCRIPTION
import static org.celllife.idart.common.Identifiers.getIdentifierValue
import static org.celllife.idart.common.Identifiers.newIdentifier

/**
 */
@Named class PrescriptionApplicationServiceImpl implements PrescriptionApplicationService {

    @Inject PrescriptionService prescriptionService

    @Inject PrescribedMedicationApplicationService prescribedMedicationApplicationService

    @Inject PrescriptionDtoAssembler prescriptionDtoAssembler

    @Inject PrescriptionProvider prehmisClinicPrescriptionProvider

    @Inject IdentifiableService identifiableService

    @Inject EncounterService encounterService

    @Override
    Boolean exists(PrescriptionId prescriptionId) {
        prescriptionService.exists(prescriptionId)
    }

    @Override
    PrescriptionId save(PrescriptionDto prescriptionDto) {

        def identifiable = identifiableService.resolveIdentifiable(PRESCRIPTION, prescriptionDto.identifiers)

        def prescriptionId = prescriptionId(identifiable.getIdentifierValue(IDART))

        def prescription = prescriptionDtoAssembler.toPrescription(prescriptionDto)
        prescription.id = prescriptionId

        prescriptionService.save(prescription)

        prescription.id
    }

    @Override
    PrescriptionDto findByPrescriptionId(PrescriptionId prescriptionId) {
        def identifier = newIdentifier(IDART, prescriptionId.value)
        findByIdentifier(identifier)
    }

    @Override
    PrescriptionDto findByIdentifier(Identifier identifier) {

        def identifiable = identifiableService.resolveIdentifiable(PRESCRIPTION, [identifier] as Set)

        if (identifiable == null) {
            throw new PrescriptionNotFoundException("Could not find null with id [${ identifier.value}]")
        }

        def prescriptionId = prescriptionId(identifiable.getIdentifierValue(IDART))

        def prescription = prescriptionService.findByPrescriptionId(prescriptionId)

        def prescriptionDto = prescriptionDtoAssembler.toPrescriptionDto(prescription)
        prescriptionDto.identifiers = identifiable.identifiers

        prescriptionDto.prescribedMedications = prescription.prescribedMedications.collect { prescribedMedication ->
            prescribedMedicationApplicationService.findByPrescribedMedicationId(prescribedMedication)
        }

        prescriptionDto
    }


    @Override
    PrescriptionId findByIdentifiers(Set<Identifier> identifiers) {

        def identifiable = identifiableService.resolveIdentifiable(PRESCRIPTION, identifiers)

        def idartIdentifierValue = getIdentifierValue(identifiable.identifiers, IDART)

        prescriptionId(idartIdentifierValue)
    }
    /**
     * TODO publish event rather than execute synchronously
     *
     * @param facility
     * @param prescription
     */
    void postToExternalProviders(PrescriptionDto prescription) {

        def encounter = encounterService.findByEncounterId(encounterId(getIdentifierValue(prescription.encounter, IDART)))

        def facilityIdentifiable = identifiableService
                .resolveIdentifiable(FACILITY, [newIdentifier(IDART, encounter.facility.value)] as Set<Identifier>)

        facilityIdentifiable.identifiers.each { facilityIdentifier ->

            switch (facilityIdentifier.authority) {
                case PREHMIS:
                    prehmisClinicPrescriptionProvider.save(facilityIdentifier.value, prescription)
                    break
                default:
                    break
            }
        }
    }
}
