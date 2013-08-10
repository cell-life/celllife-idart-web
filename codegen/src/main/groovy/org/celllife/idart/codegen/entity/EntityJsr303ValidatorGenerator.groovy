package org.celllife.idart.codegen.entity

import static EntityModelEnricher.enrichAggregateRoot

class EntityJsr303ValidatorGenerator {

    static generateEntityJsr303Validator(String baseDirectory, String baseNamespace, model) {

        enrichAggregateRoot(baseNamespace, model)

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/jsr303Validator.template",
                model: model,
                directory: baseDirectory + "/" + model.jsr303Validator.packageName.replaceAll("\\.", "/"),
                fileName: model.jsr303Validator.className + ".groovy"
        )
    }
}