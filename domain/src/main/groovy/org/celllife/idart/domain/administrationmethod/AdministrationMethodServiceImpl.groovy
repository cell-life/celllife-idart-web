package org.celllife.idart.domain.administrationmethod

import org.celllife.idart.domain.common.Code

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.annotation.Generated

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-21
 * Time: 22h05
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
        administrationMethodRepository.save(lookupAndMerge(administrationMethod))
    }

    def lookupAndMerge(AdministrationMethod administrationMethod) {

        def (String system, String value) = getLookupCode(administrationMethod)

        AdministrationMethod existingAdministrationMethod = administrationMethodRepository.findOneByCode(system, value)

        if (existingAdministrationMethod == null) {

            // Ensure that idartCodeValue is always set
            if (administrationMethod.idartCodeValue == null) {
                administrationMethod.addCode(administrationMethod.idartSystem, administrationMethod.defaultCodeValue)
            }

            return administrationMethod
        }

        existingAdministrationMethod.mergeCodes(administrationMethod)
        existingAdministrationMethod
    }

    static getLookupCode(AdministrationMethod administrationMethod) {

        if (administrationMethod.idartCodeValue == null && administrationMethod.defaultCodeValue == null) {
            throw new RuntimeException("No code for default system [${ administrationMethod.defaultSystem}] or idart system [${ administrationMethod.idartSystem}]")
        }

        if (administrationMethod.defaultCodeValue != null) {
            return [administrationMethod.defaultSystem, administrationMethod.defaultCodeValue]
        }

        return [administrationMethod.idartSystem, administrationMethod.idartCodeValue]
    }

    @Override
    Iterable<AdministrationMethod> findAll() {
        administrationMethodRepository.findAll()
    }

    @Override
    AdministrationMethod findByCode(String code) {
        administrationMethodRepository.findOneByCode(AdministrationMethod.IDART_SYSTEM, code)
    }

    @Override
    AdministrationMethod findByCodes(Iterable<Code> codes) {

        if (codes == null) {
            return null
        }

        for (code in codes) {
            def administrationMethod = administrationMethodRepository.findOneByCode(code.system, code.value)
            if (administrationMethod != null) {
                return administrationMethod
            }
        }

        null
    }
}