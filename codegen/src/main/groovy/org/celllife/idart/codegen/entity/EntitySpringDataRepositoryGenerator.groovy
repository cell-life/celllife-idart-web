package org.celllife.idart.codegen.entity

import static EntityModelEnricher.enrichAggregateRoot

class EntitySpringDataRepositoryGenerator {

    static generateEntitySpringDataRepository(String baseDirectory, String baseNamespace, model) {
        enrichAggregateRoot(baseNamespace, model)

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/" + model.springDataRepository.packageName.replaceAll("\\.", "/"),
                fileName: model.springDataRepository.className + ".java"
        )
    }
}