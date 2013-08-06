package org.celllife.idart.codegen.entity

import static EntityModelEnricher.enrichAggregateRoot

class EntityHibernateValidatorGenerator {

    static generateEntityHibernateValidator(String baseDirectory, String baseNamespace, model) {
        enrichAggregateRoot(baseNamespace, model)

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/hibernateValidator.template",
                model: model,
                directory: baseDirectory + "/" + model.hibernateValidator.packageName.replaceAll("\\.", "/"),
                fileName: model.hibernateValidator.className + ".groovy"
        )
    }
}