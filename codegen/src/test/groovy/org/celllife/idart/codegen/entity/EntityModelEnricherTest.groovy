package org.celllife.idart.codegen.entity

import groovy.text.SimpleTemplateEngine
import org.junit.Test

import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson
import static EntityModelEnricher.*
import static org.junit.Assert.assertEquals

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 11h41
 */
public class EntityModelEnricherTest {

    def baseNamespace = "http://www.cell-life.org/idart"

    def models = [
            [name: "User", entity: [_properties: [[name: "Current Username"], [name: "Current Password"]]]],
            [name: "Unit Of Measure", namePlural: "Units Of Measure", entity: [identifier: [name: "Code"], _properties: [[name: "Name"], [name: "Description"]]]]
    ]

    @Test
    public void testEnrichModel() throws Exception {
        models.each { model ->
            println prettyPrint(toJson(enrichAggregateRoot(baseNamespace, model)))
        }
    }

    @Test
    public void shouldGenerateIdentifier() throws Exception {
        def templatePath = "/templates/entity/identifier.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateEntity() throws Exception {
        def templatePath = "/templates/entity/entity.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateEntityNotFoundException() throws Exception {
        def templatePath = "/templates/entity/notFoundException.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateRepository() throws Exception {
        def templatePath = "/templates/entity/repository.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateSpringDataRepository() throws Exception {
        def templatePath = "/templates/entity/springDataRepository.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateValidator() throws Exception {
        def templatePath = "/templates/entity/validator.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateHibernateValidator() throws Exception {
        def templatePath = "/templates/entity/hibernateValidator.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateDomainServiceInterface() throws Exception {
        def templatePath = "/templates/entity/domainServiceInterface.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateDomainServiceImplmentation() throws Exception {
        def templatePath = "/templates/entity/domainServiceImplementation.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateApplicationServiceInterface() throws Exception {
        def templatePath = "/templates/entity/applicationServiceInterface.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateApplicationServiceImplementation() throws Exception {
        def templatePath = "/templates/entity/applicationServiceImplementation.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateResourceController() throws Exception {
        def templatePath = "/templates/entity/resourceController.template"
        models.each { model ->
            generate(templatePath, enrichAggregateRoot(baseNamespace, model))
        }
    }

    @Test
    public void shouldConvertToSnakeCase() throws Exception {

        assertEquals("user", toSnakeCase("User"))
        assertEquals("unit_of_measure", toSnakeCase("UnitOfMeasure"))
        assertEquals("unit_of_measure", toSnakeCase("unitOfMeasure"))
        assertEquals("unit_of_measure", toSnakeCase("Unit Of Measure"))
        assertEquals("atc_code", toSnakeCase("ATC Code"))
        assertEquals("atc_code", toSnakeCase("ATCCode"))

        assertEquals("ab", toSnakeCase("AB"))
        assertEquals("a_b", toSnakeCase("aB"))
        assertEquals("a_bc", toSnakeCase("ABc"))
        assertEquals("ab_cd", toSnakeCase("ABCd"))

    }

    @Test
    public void shouldConvertToFieldName() throws Exception {

        assertEquals("user", toFieldName("User"))
        assertEquals("unitOfMeasure", toFieldName("Unit Of Measure"))
        assertEquals("unitOfMeasure", toFieldName("Unit of Measure"))
        assertEquals("atcCode", toFieldName("ATC Code"))
        assertEquals("atcCode", toFieldName("ATCCode"))
    }

    @Test
    public void shouldConvertToBasePackage() throws Exception {
        assertEquals("org.celllife.idart", toPackage("http://www.cell-life.org/idart"))
        assertEquals("org.celllife.idart.user", toPackage("http://www.cell-life.org/idart/user"))
    }

    static void generate(String templatePath, model) {
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(new InputStreamReader(FileWriter.class.getResourceAsStream(templatePath)))
        def make = template.make(model)

        make.writeTo(new OutputStreamWriter(System.out))
    }
}
