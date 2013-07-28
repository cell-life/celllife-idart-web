package org.celllife.idart.application.clinicdispensation

import org.celllife.idart.application.clinic.ClinicResourceService
import org.celllife.idart.application.dispensation.DispensationResourceService
import org.celllife.idart.domain.clinicdispensation.ClinicDispensationService
import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.dispensation.Dispensation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service    

import javax.annotation.Generated

/**
 * Generated by org.celllife.idart.codegen.CodeGenerator
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class ClinicDispensationApplicationServiceImpl implements ClinicDispensationResourceService {

    @Autowired ClinicResourceService clinicResourceService

    @Autowired DispensationResourceService dispensationResourceService

    @Autowired ClinicDispensationService clinicDispensationService

    @Override
    void save(String clinicIdentifier, String dispensationIdentifier, Dispensation dispensation) {

        dispensation.addIdentifier(
                String.format(
                        "http://www.cell-life.org/idart/clinics/%s/dispensations",
                        clinicIdentifier
                ),
                dispensationIdentifier
        )

        save(clinicIdentifier, dispensation)
    }

    @Override
    void save(String clinicIdentifier, Dispensation dispensation) {

        def clinic = clinicResourceService.findByIdentifier(clinicIdentifier)

        dispensation = dispensationResourceService.save(dispensation)

        clinicDispensationService.save(clinic, dispensation)
    }

    @Override
    Iterable<Dispensation> findDispensationsByClinicIdentifier(String clinicIdentifier) {
         clinicDispensationService.findDispensationsByClinicIdentifier(clinicIdentifier)
    }

    @Override
    Iterable<Dispensation> findDispensationsByClinicIdentifierAndDispensationIdentifier(String clinicIdentifier, String dispensationIdentifier) {

    }

    @Override
    Dispensation findOneDispensationByClinicIdentifierAndDispensationIdentifier(String clinicIdentifier, String dispensationIdentifier) {

    }
}
