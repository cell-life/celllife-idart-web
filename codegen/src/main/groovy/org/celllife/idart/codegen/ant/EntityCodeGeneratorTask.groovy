package org.celllife.idart.codegen.ant

import groovy.json.JsonSlurper
import org.apache.tools.ant.BuildException
import org.apache.tools.ant.Task

import static org.celllife.idart.codegen.entity.EntityAggregateRootGenerator.generateEntityAggregateRoot
import static org.celllife.idart.codegen.entity.EntityApplicationServiceGenerator.generateEntityApplicationService
import static org.celllife.idart.codegen.entity.EntityJsr303ValidatorGenerator.generateEntityJsr303Validator
import static org.celllife.idart.codegen.entity.EntityResourceGenerator.generateEntityResource
import static org.celllife.idart.codegen.entity.EntitySpringDataRepositoryGenerator.generateEntitySpringDataRepository

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 18h58
 */
class EntityCodeGeneratorTask extends Task {

    String baseDir

    String baseNamespace

    String modelFile

    EntityCodeGeneratorAction action

    @Override
    void execute() throws BuildException {

        def aggregateRoots = new JsonSlurper().parse(new FileReader(modelFile))

        switch (action) {
            case EntityCodeGeneratorAction.application :
                generateEntityResources("${baseDir}/webapp/src/main/groovy", baseNamespace, aggregateRoots)
                break
            case EntityCodeGeneratorAction.domain :
                generateEntityAggregateRoots("${baseDir}/domain/src/main/groovy", baseNamespace, aggregateRoots)
                break
            case EntityCodeGeneratorAction.infrastructure :
                generateEntitySpringDataRepositories("${baseDir}/webapp/src/main/java", baseNamespace, aggregateRoots)
                generateEntityJsr303Validators("${baseDir}/webapp/src/main/groovy", baseNamespace, aggregateRoots)
                break
            default:
                generateEntityResources("${baseDir}/webapp/src/main/groovy", baseNamespace, aggregateRoots)
                generateEntityAggregateRoots("${baseDir}/domain/src/main/groovy", baseNamespace, aggregateRoots)
                generateEntitySpringDataRepositories("${baseDir}/webapp/src/main/java", baseNamespace, aggregateRoots)
                generateEntityJsr303Validators("${baseDir}/webapp/src/main/groovy", baseNamespace, aggregateRoots)
        }
    }

    void setBaseDir(String baseDir) {
        this.baseDir = baseDir
    }

    void setBaseNamespace(String baseNamespace) {
        this.baseNamespace = baseNamespace
    }

    void setModelFile(String modelFile) {
        this.modelFile = modelFile
    }

    void setAction(EntityCodeGeneratorAction action) {
        this.action = action
    }

    static generateEntityAggregateRoots(sourcesDirectory, baseNamespace, models) {
        models.each { model ->
            generateEntityAggregateRoot(sourcesDirectory, baseNamespace, model)
        }
    }

    static generateEntityResources(sourcesDirectory, baseNamespace, models) {
        models.each { model ->
            generateEntityResource(sourcesDirectory, baseNamespace, model)
            generateEntityApplicationService(sourcesDirectory, baseNamespace, model)
        }
    }

    static generateEntitySpringDataRepositories(sourcesDirectory, baseNamespace, models) {
        models.each { model ->
            generateEntitySpringDataRepository(sourcesDirectory, baseNamespace, model) }
    }

    static generateEntityJsr303Validators(sourcesDirectory, baseNamespace, models) {
        models.each { model ->
            generateEntityJsr303Validator(sourcesDirectory, baseNamespace, model)
        }
    }
}
