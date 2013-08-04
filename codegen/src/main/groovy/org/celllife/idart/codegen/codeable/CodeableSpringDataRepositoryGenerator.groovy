package org.celllife.idart.codegen.codeable

class CodeableSpringDataRepositoryGenerator {

    static generateCodeableSpringDataRepository(String baseDirectory, model) {

        org.celllife.idart.codegen.FileWriter.toFile(
                templateReader: "/templates/codeable/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/"),
                fileName: "SpringData" + model.entityName + "Repository.java"
        )
    }
}