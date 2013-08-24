package org.celllife.idart.codegen.relationship

import org.celllife.idart.codegen.FileWriter

class RelationshipSpringDataRepositoryGenerator {

    static generateRelationshipSpringDataRepository(String baseDirectory, model) {

        FileWriter.toFile(
                templateReader: "/templates/relationship/springDataRepository.template",
                model: model,
                directory: baseDirectory + "/" + model.springDataPackageName.replaceAll("\\.", "/"),
                fileName: "SpringData" + model.className + "Repository.java"
        )
    }
}
