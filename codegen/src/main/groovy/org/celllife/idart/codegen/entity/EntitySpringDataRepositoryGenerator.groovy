package org.celllife.idart.codegen.entity

class EntitySpringDataRepositoryGenerator {

    static generateEntitySpringDataRepository(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/entity/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/"),
                fileName: "SpringData" + model.entityName + "Repository.java"
        )
    }
}