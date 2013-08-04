package org.celllife.idart.codegen

import org.celllife.idart.codegen.entity.EntityAggregateRootGenerator
import org.celllife.idart.codegen.entity.EntityApplicationServiceGenerator
import org.celllife.idart.codegen.entity.EntityResourceGenerator
import org.celllife.idart.codegen.entity.EntitySpringDataRepositoryGenerator

import javax.swing.text.html.parser.Entity

import static org.celllife.idart.codegen.codeable.CodeableSpringDataRepositoryGenerator.generateCodeableSpringDataRepository
import static org.celllife.idart.codegen.entity.EntityAggregateRootGenerator.generateEntityAggregateRoot
import static org.celllife.idart.codegen.entity.EntityApplicationServiceGenerator.generateEntityApplicationService
import static org.celllife.idart.codegen.entity.EntityResourceGenerator.generateEntityResource
import static org.celllife.idart.codegen.entity.EntitySpringDataRepositoryGenerator.generateEntitySpringDataRepository
import static org.celllife.idart.codegen.identifiable.IdentifiableAggregateRootGenerator.generateIdentifiableAggregateRoot
import static org.celllife.idart.codegen.identifiable.IdentifiableApplicationServiceGenerator.generateIdentifiableApplicationService
import static org.celllife.idart.codegen.identifiable.IdentifiableResourceGenerator.generateIdentifiableResource
import static org.celllife.idart.codegen.codeable.CodeableAggregateRootGenerator.generateCodeableAggregateRoot
import static org.celllife.idart.codegen.codeable.CodeableResourceGenerator.generateCodeableResource
import static org.celllife.idart.codegen.codeable.CodeableApplicationServiceGenerator.generateCodeableApplicationService
import static org.celllife.idart.codegen.identifiable.IdentifiableSpringDataRepositoryGenerator.generateIdentifiableSpringDataRepository
import static org.celllife.idart.codegen.ModelEnricher.enrichModel
import static org.celllife.idart.codegen.relationship.RelationshipAggregateRootGenerator.generateRelationshipAggregateRoot
import static org.celllife.idart.codegen.relationship.RelationshipApplicationServiceGenerator.generateRelationshipApplicationService
import static org.celllife.idart.codegen.relationship.RelationshipModelEnricher.enrichRelationshipModel
import static org.celllife.idart.codegen.relationship.RelationshipSpringDataRepositoryGenerator.generateRelationshipSpringDataRepository

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 18h58
 */
class CodeGenerator {

    def groovySourcesDirectory

    def javaSourcesDirectory

    def basePackageName

    CodeGenerator(args) {

        this.groovySourcesDirectory = args.groovySourcesDirectory

        this.javaSourcesDirectory = args.javaSourcesDirectory

        this.basePackageName = args.basePackageName
    }

    def generateCounterSequence(models) {
        models.each { model ->
            CounterSequenceGenerator.generateCounterSequence(groovySourcesDirectory, model)
        }
    }

    def generateHibernateValidator(models) {
        models.each { model ->
            HibernateValidatorGenerator.generateHibernateValidator(groovySourcesDirectory, model)
        }
    }

    def generateIdentifiableResources(models) {
        models.each { model ->
            generateIdentifiableResource(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
            generateIdentifiableApplicationService(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
        }
    }

    def generateIdentifiableAggregateRoot(models) {
        models.each { model -> generateIdentifiableAggregateRoot(groovySourcesDirectory, basePackageName, model) }
    }

    def generateIdentifiableSpringDataRepositories(models) {
        models.each { model ->
            enrichModel(basePackageName, model)
            generateIdentifiableSpringDataRepository(javaSourcesDirectory, model) }
    }

    def generateCodeableResources(models) {
        models.each { model ->
            generateCodeableResource(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
            generateCodeableApplicationService(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
        }
    }
    def generateCodeableAggregateRoot(models) {
        models.each { model -> generateCodeableAggregateRoot(groovySourcesDirectory, basePackageName, model) }
    }

    def generateCodeableSpringDataRepositories(models) {
        models.each { model ->
            enrichModel(basePackageName, model)
            generateCodeableSpringDataRepository(javaSourcesDirectory, model)
        }
    }

    def generateRelationshipResources(models) {
        models.each { model ->
            generateRelationshipApplicationService(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
        }
    }

    def generateRelationshipAggregateRoot(models) {
        models.each { model ->
            generateRelationshipAggregateRoot(groovySourcesDirectory, basePackageName, model)
        }
    }

    def generateRelationshipSpringDataRepositories(models) {
        models.each { model ->
            enrichRelationshipModel(basePackageName, model)
            generateRelationshipSpringDataRepository(javaSourcesDirectory, model) }
    }

    def generateEntityResources(models) {
        models.each { model ->
            generateEntityResource(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
            generateEntityApplicationService(groovySourcesDirectory, javaSourcesDirectory, basePackageName, model)
        }
    }

    def generateEntityAggregateRoots(models) {
        models.each { model ->
            generateEntityAggregateRoot(groovySourcesDirectory, basePackageName, model)
        }
    }

    def generateEntitySpringDataRepositories(models) {
        models.each { model ->
            enrichModel(basePackageName, model)
            generateEntitySpringDataRepository(javaSourcesDirectory, model) }
    }
}
