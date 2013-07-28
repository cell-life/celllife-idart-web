package org.celllife.idart.domain.clinicpractitioner

import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.practitioner.Practitioner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class ClinicPractitionerServiceImpl implements ClinicPractitionerService {

    @Autowired ClinicPractitionerRepository clinicPractitionerRepository

    @Override
    boolean exists(Clinic clinic, Practitioner practitioner, Date dateActive) {
        clinicPractitionerRepository.countByClinicAndPractitionerAndDateActive(clinic, practitioner, dateActive) == 0
    }

    @Override
    void save(Clinic clinic, Practitioner practitioner) {

        def dateActive = new Date()

        if (exists(clinic, practitioner, dateActive)) {
            clinicPractitionerRepository
                    .save(new ClinicPractitioner(clinic: clinic, practitioner: practitioner, fromDate: dateActive))
        }
    }


    @Override
    void save(Clinic clinic, Iterable<Practitioner> practitioners) {
        practitioners.each { practitioner -> save(clinic, practitioner) }
    }

    @Override
    void save(Practitioner practitioner, Iterable<Clinic> clinics) {
        clinics.each { clinic -> save(clinic, practitioner) }
    }

    @Override
    void deleteByClinic(Clinic clinic) {
        findPractitionersByClinic(clinic).each { practitioner -> delete(clinic, practitioner) }
    }

    @Override
    void deleteByPractitioner(Practitioner practitioner) {
        findClinicsByPractitioner(practitioner).each { clinic -> delete(clinic, practitioner) }
    }

    @Override
    void delete(Clinic clinic, Practitioner practitioner) {

        ClinicPractitioner clinicPractitioner =
            clinicPractitionerRepository.findByClinicAndPractitionerAndDateActive(clinic, practitioner, new Date())

        if (clinicPractitioner != null) {
            clinicPractitioner.thruDate = new Date()
            clinicPractitionerRepository.save(clinicPractitioner)
        }
    }

    @Override
    Iterable<Practitioner> findPractitionersByClinic(Clinic clinic) {
        clinicPractitionerRepository
                .findByClinicAndDateActive(clinic, new Date())
                .collect { clinicPractitioner -> clinicPractitioner.practitioner }
    }

    @Override
    Iterable<Practitioner> findPractitionersByClinicIdentifier(String clinicIdentifier) {
        clinicPractitionerRepository
                .findByClinicIdentifierAndDateActive(clinicIdentifier, new Date())
                .collect { clinicPractitioner -> clinicPractitioner.practitioner }
    }
            
    @Override
    Iterable<Practitioner> findPractitionersByClinicIdentifierAndPractitionerIdentifier(String clinicIdentifier, String practitionerIdentifier) {
        clinicPractitionerRepository
                .findByClinicIdentifierAndPractitionerIdentifierAndDateActive(
                        clinicIdentifier,
                        practitionerIdentifier,
                        new Date()
                )
                .collect { clinicPractitioner -> clinicPractitioner.practitioner }
    }
         
    @Override
    Practitioner findOnePractitionerByClinicIdentifierAndPractitionerIdentifier(String clinicIdentifier, String practitionerIdentifier) {
        clinicPractitionerRepository
                .findOneByClinicIdentifierAndPractitionerIdentifierAndDateActive(
                        clinicIdentifier,
                        practitionerIdentifier,
                        new Date()
                )?.practitioner
    }

    @Override
    Iterable<Clinic> findClinicsByPractitioner(Practitioner practitioner) {
        clinicPractitionerRepository
                .findByPractitionerAndDateActive(practitioner, new Date())
                .collect { clinicPractitioner -> clinicPractitioner.clinic }
    }
}
