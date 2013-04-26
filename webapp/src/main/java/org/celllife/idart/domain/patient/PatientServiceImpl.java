package org.celllife.idart.domain.patient;

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

    public Patient findByIdentifiers(Set<PatientIdentifier> identifiers) {

        for (PatientIdentifier identifier : identifiers) {

            Patient patient = patientRepository.findOneByIdentifier(identifier.getValue(), identifier.getType());
            if (patient != null) {
                return patient;
            }
        }

        return null;
    }
}
