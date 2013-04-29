package org.celllife.idart.domain.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-29
 * Time: 16h47
 */
@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor findByIdentifiers(Set<DoctorIdentifier> identifiers) {

        for (DoctorIdentifier identifier : identifiers) {

            Doctor doctor = doctorRepository.findOneByIdentifier(identifier.getValue(), identifier.getType());
            if (doctor != null) {
                return doctor;
            }
        }

        return null;
    }
}
