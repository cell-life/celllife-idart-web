package org.celllife.idart.codegen

class CounterSequenceGenerator {

    static generateCounterSequence(String baseDirectory, model) {

        def directory = baseDirectory + "/" + model.counterPackageName.replaceAll("\\.", "/")
        def fileName = "Counter" + model.entityName + "Sequence.groovy"

        Output.toFile(
                templateReader: "/templates/counterSequence.template",
                model: model,
                directory: directory,
                fileName: fileName
        )
    }
}