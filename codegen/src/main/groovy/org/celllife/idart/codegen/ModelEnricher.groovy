package org.celllife.idart.codegen

import java.text.SimpleDateFormat

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 21h34
 */
class ModelEnricher {

    static enrichModel(basePackageName, model) {

        if (model.entityNamePlural == null) {
            model.entityNamePlural = model.entityName + "s"
        }

        model.resourcePath = model.entityNamePlural.substring(0, 1).toLowerCase() + model.entityNamePlural.substring(1)

        model.lowerCaseEntityName = model.entityName.substring(0, 1).toLowerCase() + model.entityName.substring(1)

        if (model.entityPackage == null) {
            model.entityPackage = model.entityName.toLowerCase()
        }

        model.lowerCaseEntityNamePlural = model.entityNamePlural.substring(0, 1).toLowerCase() + model.entityNamePlural.substring(1)

        if (model.resourcePath == null) {
            model.resourcePath = model.lowerCaseEntityNamePlural
        }

        model.domainPackageName = basePackageName + ".domain." + model.entityPackage
        model.applicationPackageName = basePackageName + ".application." + model.entityPackage
        model.resourcePackageName = basePackageName + ".interfaces.service." + model.entityPackage
        model.springDataPackageName = basePackageName + ".infrastructure.springdata." + model.entityPackage

        model.currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date())

        model.currentTime = new SimpleDateFormat("HH'h'mm").format(new Date())
    }

}
