package org.celllife.idart.domain.clinic

import org.celllife.idart.domain.common.Identifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class ClinicServiceImpl implements ClinicService {

    @Autowired ClinicRepository clinicRepository

    @Autowired ClinicSequence clinicSequence

    @Autowired ClinicValidator clinicValidator

    @Override
    Clinic save(Clinic newClinic) {

        clinicValidator.validate(newClinic)

        def existingClinic = findByIdentifiers(newClinic.identifiers)

        if (requiresIdartIdentifier(newClinic, existingClinic)) {
            newClinic.addIdentifier(Clinic.IDART_SYSTEM, nextPatientIdentifier())
        }

        if (existingClinic == null) {
            existingClinic = new Clinic()
        }

        existingClinic.merge(newClinic)

        clinicRepository.save(existingClinic)
    }

    @Override
    Clinic findByIdentifiers(Iterable<Identifier> identifiers) {
        for (identifier in identifiers) {
            def existingClinic = clinicRepository.findOneByIdentifier(identifier.system, identifier.value)
            if (existingClinic != null) {
                return existingClinic
            }
        }

        null
    }

    @Override
    Clinic findByIdentifier(String identifier) {
        clinicRepository.findOneByIdentifier(Clinic.IDART_SYSTEM, identifier)
    }

    @Override
    Iterable<Clinic> findAll() {
        clinicRepository.findAll()
    }

    String nextPatientIdentifier() {
        String.format("%08d", clinicSequence.nextValue())
    }

    static requiresIdartIdentifier(Clinic... clinics) {

        for (Clinic clinic in clinics) {
            if (clinic?.hasIdentifierForSystem(Clinic.IDART_SYSTEM)) {
                return false
            }
        }

        return true
    }
}
