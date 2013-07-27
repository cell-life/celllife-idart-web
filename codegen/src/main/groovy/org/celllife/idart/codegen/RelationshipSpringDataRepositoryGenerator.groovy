package org.celllife.idart.codegen

class RelationshipSpringDataRepositoryGenerator {

    static generateRelationshipSpringDataRepository(String baseDirectory, model) {

        Output.toFile(
                templateReader: "/templates/relationship/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/"),
                fileName: "SpringData" + model.className + "Repository.java"
        )
    }
}