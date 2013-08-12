package org.celllife.idart.codegen.relationship

import groovy.text.SimpleTemplateEngine
import org.junit.Ignore
import org.junit.Test

import static groovy.json.JsonOutput.prettyPrint
import static groovy.json.JsonOutput.toJson
import static org.celllife.idart.codegen.relationship.RelationshipModelEnricher.enrichRelationshipModel

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-04
 * Time: 19h16
 */
@Ignore
class RelationshipModelEnricherTest {

    def baseNamespace = "http://www.cell-life.org/idart"

    def models = [
            [from: [name: "User"], to: [name: "System"], relationships: [[name: "For"]]],
            [from: [name: "System"], to: [name: "Facility", namePlural: "Facilities"], relationships: [[name: "Deployed At"]]]
    ]

    @Test
    public void testEnrichModel() throws Exception {
        models.each { model ->
            println prettyPrint(toJson(enrichRelationshipModel(baseNamespace, model)))
        }
    }

    @Test
    public void shouldGenerateEntity() throws Exception {
        def templatePath = "/templates/relationship/entity.template"
        models.each { model ->
            generate(templatePath, enrichRelationshipModel(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateRepository() throws Exception {
        def templatePath = "/templates/relationship/repository.template"
        models.each { model ->
            generate(templatePath, enrichRelationshipModel(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateSpringDataRepository() throws Exception {
        def templatePath = "/templates/relationship/springDataRepository.template"
        models.each { model ->
            generate(templatePath, enrichRelationshipModel(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateDomainServiceInterface() throws Exception {
        def templatePath = "/templates/relationship/domainServiceInterface.template"
        models.each { model ->
            generate(templatePath, enrichRelationshipModel(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateDomainServiceImplmentation() throws Exception {
        def templatePath = "/templates/relationship/domainServiceImplementation.template"
        models.each { model ->
            generate(templatePath, enrichRelationshipModel(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateApplicationServiceInterface() throws Exception {
        def templatePath = "/templates/relationship/applicationServiceInterface.template"
        models.each { model ->
            generate(templatePath, enrichRelationshipModel(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateApplicationServiceImplementation() throws Exception {
        def templatePath = "/templates/relationship/applicationServiceImplementation.template"
        models.each { model ->
            generate(templatePath, enrichRelationshipModel(baseNamespace, model))
        }
    }

    @Test
    public void shouldGenerateResourceController() throws Exception {
        def templatePath = "/templates/relationship/resourceController.template"
        models.each { model ->
            generate(templatePath, enrichRelationshipModel(baseNamespace, model))
        }
    }

    static void generate(String templatePath, model) {
        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(new InputStreamReader(FileWriter.class.getResourceAsStream(templatePath)))
        def make = template.make(model)

        make.writeTo(new OutputStreamWriter(System.out))
    }
}
