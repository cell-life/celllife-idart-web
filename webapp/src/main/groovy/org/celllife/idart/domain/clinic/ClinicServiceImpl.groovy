package org.celllife.idart.domain.clinic

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 02h48
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class ClinicServiceImpl implements ClinicService {

    @Autowired ClinicRepository clinicRepository

    @Override
    Clinic save(Clinic clinic) {

        Clinic existingClinic = findByIdentifiers(clinic.identifiers)
        if (existingClinic == null) {
            existingClinic = clinic.class.newInstance()
        }

        existingClinic.merge(clinic)

        clinicRepository.save(existingClinic)
    }


    @Override
    Iterable<Clinic> findAll() {
        clinicRepository.findAll()
    }

    @Override
    Clinic findByIdentifier(String identifier) {
        null
    }

    @Override
    Clinic findByIdentifiers(Set<Identifier> identifiers) {

        for (Identifier identifier: identifiers) {
            Clinic clinic = clinicRepository.findOneByIdentifier(identifier.value, identifier.system)
            if (clinic != null) {
                return clinic
            }
        }

        null
    }
}