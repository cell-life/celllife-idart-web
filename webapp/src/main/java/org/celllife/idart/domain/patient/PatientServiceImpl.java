package org.celllife.idart.domain.patient;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 12h48
 */
@Service("patientService")
public final class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Mapper mapper;

    public Iterable<Patient> save(Iterable<Patient> patients) {

        for (Patient newPatient : patients) {
            Patient existingPatient = findByIdentifiers(newPatient.getIdentifiers());
            if (existingPatient != null) {
                mapper.map(existingPatient, newPatient);
            }
        }

        return patientRepository.save(patients);
    }

    private Patient findByIdentifiers(Set<PatientIdentifier> identifiers) {

        for (PatientIdentifier identifier : identifiers) {

            Patient patient = patientRepository.findOneByIdentifier(identifier.getValue(), identifier.getType());
            if (patient != null) {
                return patient;
            }
        }

        return null;
    }
}
