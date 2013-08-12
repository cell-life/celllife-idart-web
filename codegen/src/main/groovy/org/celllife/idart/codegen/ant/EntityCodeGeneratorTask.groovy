package org.celllife.idart.codegen.ant

import groovy.json.JsonSlurper
import org.apache.tools.ant.BuildException
import org.apache.tools.ant.Task
import org.celllife.idart.codegen.entity.EntityCodeGenerator

import static EntityCodeGenerator.generateEntity
import static org.celllife.idart.codegen.entity.EntityCodeGenerator.generateEntityCode
import static org.celllife.idart.codegen.entity.EntityIdentifierGenerator.generateEntityIdentifier
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

        def models = new JsonSlurper().parse(new FileReader(modelFile))

        models.each { model ->
            generateEntityCode(baseDir, baseNamespace, model)
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

}
