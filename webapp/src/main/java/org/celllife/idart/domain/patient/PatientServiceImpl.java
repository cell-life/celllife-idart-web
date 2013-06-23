package org.celllife.idart.domain.patient;

import org.celllife.idart.domain.concept.Identifier;
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

    public Patient findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier : identifiers) {

            Patient patient = patientRepository.findOneByIdentifier(identifier.getSystem(), identifier.getValue());
            if (patient != null) {
                return patient;
            }
        }

        return null;
    }

    public void save(Patient newPatient) {

        Patient existingPatient = findByIdentifiers(newPatient.getIdentifiers());

        if (existingPatient != null) {
            mapper.map(newPatient, existingPatient);
            patientRepository.save(existingPatient);
        } else {
            patientRepository.save(newPatient);
        }
    }
}
