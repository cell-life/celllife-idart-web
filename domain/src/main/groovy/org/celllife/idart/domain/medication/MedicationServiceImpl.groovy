package org.celllife.idart.domain.medication

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class MedicationServiceImpl implements MedicationService {

    @Autowired MedicationRepository medicationRepository

    @Autowired MedicationSequence medicationSequence

    @Autowired MedicationValidator medicationValidator

    @Override
    Medication save(Medication newMedication) {

        medicationValidator.validate(newMedication)

        def existingMedication = findByIdentifiers(newMedication.identifiers)

        if (requiresIdartIdentifier(newMedication, existingMedication)) {
            newMedication.addIdentifier(Medication.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingMedication == null) {
            existingMedication = new Medication()
        }

        existingMedication.merge(newMedication)

        medicationRepository.save(existingMedication)
    }

    @Override
    Medication findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingMedication = medicationRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingMedication != null) {
                return existingMedication
            }
        }

        null
    }

    @Override
    Medication findByIdentifier(String identifier) {
        medicationRepository.findOneByIdentifier(Medication.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Medication> findAll() {
        medicationRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", medicationSequence.nextValue())
    }

    static requiresIdartIdentifier(Medication... medications) {

        for (Medication medication in medications) {
            if (medication?.hasIdentifierForSystem(Medication.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
