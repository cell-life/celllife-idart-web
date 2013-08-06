package org.celllife.idart.domain.patient

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class PatientServiceImpl implements PatientService {

    @Autowired PatientRepository patientRepository

    @Autowired PatientSequence patientSequence

    @Autowired PatientValidator patientValidator

    @Override
    Patient save(Patient newPatient) {

        patientValidator.validate(newPatient)

        def existingPatient = findByIdentifiers(newPatient.identifiers)

        if (requiresIdartIdentifier(newPatient, existingPatient)) {
            newPatient.addIdentifier(Patient.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingPatient == null) {
            existingPatient = new Patient()
        }

        existingPatient.merge(newPatient)

        patientRepository.save(existingPatient)
    }

    @Override
    Patient findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingPatient = patientRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingPatient != null) {
                return existingPatient
            }
        }

        null
    }

    @Override
    Patient findByIdentifier(String identifier) {
        patientRepository.findOneByIdentifier(Patient.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Patient> findAll() {
        patientRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", patientSequence.nextValue())
    }

    static requiresIdartIdentifier(Patient... patients) {

        for (Patient patient in patients) {
            if (patient?.hasIdentifierForSystem(Patient.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
