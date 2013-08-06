import groovy.json.JsonSlurper
import org.celllife.idart.codegen.CodeGenerator

def codeGen = new CodeGenerator(
        groovySourcesDirectory: "${project.basedir}/src/main/groovy",
        javaSourcesDirectory: "${project.basedir}/src/main/java",
        basePackageName: project.groupId,
        baseNamespace: "http://www.cell-life.org/idart"
)

def aggregateRoots = new JsonSlurper().parse(new FileReader("${project.basedir}/../aggregateRoots.json"))
codeGen.generateEntityAggregateRoots(aggregateRoots)

codeGen.generateIdentifiableAggregateRoot([
        [entityName: "Clinic"],
        [entityName: "Dispensation"],
        [entityName: "DispensedMedication"],
        [entityName: "Encounter"],
        [entityName: "Medication"],
        [entityName: "Patient"],
        [entityName: "Person", entityNamePlural: "People"],
        [entityName: "Prescription"],
        [entityName: "PrescribedMedication"],
        [entityName: "Practitioner"],
        [entityPackage: "organisation", entityName: "LegalOrganisation"],
        [entityName: "Compound"],
        [entityName: "Drug"]
])


def relationships = new JsonSlurper().parse(new FileReader("${project.basedir}/../relationships.json"))
//codeGen.generateRelationshipAggregateRoot(relationshipModels)