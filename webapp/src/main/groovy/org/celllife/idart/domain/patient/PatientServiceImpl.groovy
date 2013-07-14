package org.celllife.idart.domain.patient

import org.celllife.idart.domain.common.Identifier
import org.dozer.Mapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h48
 */
@Service class PatientServiceImpl implements PatientService {

    @Autowired PatientRepository patientRepository

    @Autowired Mapper mapper

    Patient findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier in identifiers) {
            Patient patient = patientRepository.findOneByIdentifier(identifier.getSystem(), identifier.getValue())
            if (patient != null) {
                return patient
            }
        }

        null
    }

    Patient save(Patient newPatient) {

        Patient existingPatient = findByIdentifiers(newPatient.getIdentifiers())

        if (existingPatient != null) {
            mapper.map(newPatient, existingPatient)
            return patientRepository.save(existingPatient)
        }

        return patientRepository.save(newPatient)
    }
}
