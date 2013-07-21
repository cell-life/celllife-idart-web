package org.celllife.idart.domain.administrationmethod

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 03h45
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Service class AdministrationMethodServiceImpl implements AdministrationMethodService {

    @Autowired AdministrationMethodRepository administrationMethodRepository

    @Override
    Iterable<AdministrationMethod> save(Iterable<AdministrationMethod> administrationMethods) {
        administrationMethods.collect { administrationMethod -> (save(administrationMethod)) }
    }

    @Override
    AdministrationMethod save(AdministrationMethod administrationMethod) {

        String system = administrationMethod.getFirstSystem()
        String code = administrationMethod.getCodeValue(system)

        AdministrationMethod savedAdministrationMethod = administrationMethodRepository.findOneByCode(system, code)

        if (savedAdministrationMethod != null) {
            savedAdministrationMethod.mergeCodes(administrationMethod)
            return administrationMethodRepository.save(savedAdministrationMethod)
        } else {
            return administrationMethodRepository.save(administrationMethod)
        }
    }              
    
    @Override
    Iterable<AdministrationMethod> findAll() {
        administrationMethodRepository.findAll()
    }

    @Override
    AdministrationMethod findByIdentifier(String identifier) {
        null
    }
}