package org.celllife.idart.domain.patient

import org.celllife.idart.domain.common.Identifier
import org.celllife.idart.domain.partyrole.PartyRole
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import static org.celllife.idart.domain.patient.Patients.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h48
 */
@Service class PatientServiceImpl implements PatientService {

    @Autowired PatientRepository patientRepository

    @Autowired PatientSequence patientSequence

    Patient findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier in identifiers) {
            Patient patient = patientRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (patient != null) {
                return patient
            }
        }

        null
    }

    Patient save(Patient newPatient) {

        Patient existingPatient = findByIdentifiers(newPatient.identifiers)

        if (requiresIdartIdentifier(newPatient, existingPatient)) {
            ((PartyRole) newPatient).addIdentifier(IDART_PATIENT_IDENTIFIER_SYSTEM, nextPatientIdentifier())
        }

        if (existingPatient != null) {
            existingPatient.merge(newPatient)
            return patientRepository.save(existingPatient)
        }

        return patientRepository.save(newPatient)
    }

    private String nextPatientIdentifier() {
        String.format(IDART_PATIENT_IDENTIFIER_FORMAT, patientSequence.nextValue())
    }
}
