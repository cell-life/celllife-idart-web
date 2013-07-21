package org.celllife.idart.application.clinic

import org.celllife.idart.domain.clinic.Clinic
import org.celllife.idart.domain.clinic.ClinicService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-18
 * Time: 20h48
 */
@Service
@Mixin(ClinicApplicationServiceMixin)
class ClinicApplicationServiceImpl implements ClinicApplicationService, ClinicResourceService {

    @Autowired ClinicService clinicService

    @Override
    Clinic save(Clinic clinic) {
        clinicService.save(clinic)
    }

    @Override
    Clinic findByIdentifier(String identifier) {
        clinicService.findByIdentifier(identifier)
    }

    @Override
    Iterable<Clinic> findAll() {
        clinicService.findAll()
    }
}
