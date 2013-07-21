package org.celllife.idart.codegen

class EntityGenerator {

    static generateEntity(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.domainPackageName.replaceAll("\\.", "/")
        def fileName = model.entityName + ".groovy"

        Output.toFile(
                templateReader: "/templates/entity.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }
}