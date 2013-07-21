package org.celllife.idart.application.administrationmethod

import org.celllife.idart.domain.administrationmethod.AdministrationMethod
import org.celllife.idart.domain.administrationmethod.AdministrationMethodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 01h28
 */
@Service
@Mixin(AdministrationMethodApplicationServiceMixin)
class AdministrationMethodApplicationServiceImpl implements AdministrationMethodApplicationService, AdministrationMethodResourceService {

    @Autowired AdministrationMethodService administrationMethodService

    AdministrationMethod save(AdministrationMethod administrationMethod) {
        administrationMethodService.save(administrationMethod)
    }

    AdministrationMethod findByCode(String code) {
        administrationMethodService.findByIdentifier(code)
    }

    Iterable<AdministrationMethod> findAll() {
        administrationMethodService.findAll()
    }

}