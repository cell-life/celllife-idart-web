package org.celllife.idart.codegen.identifiable

class IdentifiableSpringDataRepositoryGenerator {

    static generateIdentifiableSpringDataRepository(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/identifiable/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/"),
                fileName: "SpringData" + model.entityName + "Repository.java"
        )
    }
}