package org.celllife.idart.domain.prescribedmedication

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PrescribedMedicationServiceImpl implements PrescribedMedicationService {

    @Autowired PrescribedMedicationRepository prescribedMedicationRepository

    @Autowired PrescribedMedicationSequence prescribedMedicationSequence

    @Autowired PrescribedMedicationValidator prescribedMedicationValidator

    @Override
    PrescribedMedication save(PrescribedMedication newPrescribedMedication) {

        prescribedMedicationValidator.validate(newPrescribedMedication)

        def existingPrescribedMedication = findByIdentifiers(newPrescribedMedication.identifiers)

        if (requiresIdartIdentifier(newPrescribedMedication, existingPrescribedMedication)) {
            newPrescribedMedication.addIdentifier(PrescribedMedication.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingPrescribedMedication == null) {
            existingPrescribedMedication = new PrescribedMedication()
        }

        existingPrescribedMedication.merge(newPrescribedMedication)

        prescribedMedicationRepository.save(existingPrescribedMedication)
    }

    @Override
    PrescribedMedication findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingPrescribedMedication = prescribedMedicationRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingPrescribedMedication != null) {
                return existingPrescribedMedication
            }
        }

        null
    }

    @Override
    PrescribedMedication findByIdentifier(String identifier) {
        prescribedMedicationRepository.findOneByIdentifier(PrescribedMedication.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<PrescribedMedication> findAll() {
        prescribedMedicationRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", prescribedMedicationSequence.nextValue())
    }

    static requiresIdartIdentifier(PrescribedMedication... prescribedMedications) {

        for (PrescribedMedication prescribedMedication in prescribedMedications) {
            if (prescribedMedication?.hasIdentifierForSystem(PrescribedMedication.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
