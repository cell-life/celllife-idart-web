package org.celllife.idart.domain.dispensedmedication

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class DispensedMedicationServiceImpl implements DispensedMedicationService {

    @Autowired DispensedMedicationRepository dispensedMedicationRepository

    @Autowired DispensedMedicationSequence dispensedMedicationSequence

    @Autowired DispensedMedicationValidator dispensedMedicationValidator

    @Override
    DispensedMedication save(DispensedMedication newDispensedMedication) {

        dispensedMedicationValidator.validate(newDispensedMedication)

        def existingDispensedMedication = findByIdentifiers(newDispensedMedication.identifiers)

        if (requiresIdartIdentifier(newDispensedMedication, existingDispensedMedication)) {
            newDispensedMedication.addIdentifier(DispensedMedication.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingDispensedMedication == null) {
            existingDispensedMedication = new DispensedMedication()
        }

        existingDispensedMedication.merge(newDispensedMedication)

        dispensedMedicationRepository.save(existingDispensedMedication)
    }

    @Override
    DispensedMedication findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingDispensedMedication = dispensedMedicationRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingDispensedMedication != null) {
                return existingDispensedMedication
            }
        }

        null
    }

    @Override
    DispensedMedication findByIdentifier(String identifier) {
        dispensedMedicationRepository.findOneByIdentifier(DispensedMedication.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<DispensedMedication> findAll() {
        dispensedMedicationRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", dispensedMedicationSequence.nextValue())
    }

    static requiresIdartIdentifier(DispensedMedication... dispensedMedications) {

        for (DispensedMedication dispensedMedication in dispensedMedications) {
            if (dispensedMedication?.hasIdentifierForSystem(DispensedMedication.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
