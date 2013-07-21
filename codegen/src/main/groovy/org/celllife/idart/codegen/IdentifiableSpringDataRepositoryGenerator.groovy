package org.celllife.idart.codegen

class IdentifiableSpringDataRepositoryGenerator {

    static generateIdentifiableSpringDataRepository(String baseDirectory, model) {
        Output.toFile(
                templateReader: "/templates/identifiable/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/"),
                fileName: "SpringData" + model.entityName + "Repository.java"
        )
    }
}