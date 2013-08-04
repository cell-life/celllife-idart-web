package org.celllife.idart.codegen

class HibernateValidatorGenerator {

    static generateHibernateValidator(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.validationPackageName.replaceAll("\\.", "/")
        def fileName = "Hibernate" + model.entityName + "Validator.groovy"

        FileWriter.toFile(
                templateReader: "/templates/hibernateValidator.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }
}