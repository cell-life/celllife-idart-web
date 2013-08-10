import groovy.json.JsonSlurper
import org.celllife.idart.codegen.CodeGenerator

def codeGen = new CodeGenerator(
        groovySourcesDirectory: "${project.basedir}/src/main/groovy",
        javaSourcesDirectory: "${project.basedir}/src/main/java",
        basePackageName: project.groupId,
        baseNamespace: "http://www.cell-life.org/idart"
)
def aggregateRoots = new JsonSlurper().parse(new FileReader("${project.basedir}/../model/aggregateRoots.json"))
codeGen.generateEntitySpringDataRepositories(aggregateRoots)
codeGen.generateEntityResources(aggregateRoots)
codeGen.generateEntityHibernateValidators(aggregateRoots)

def identifiableModels = [
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
]

codeGen.generateIdentifiableSpringDataRepositories(identifiableModels)
codeGen.generateIdentifiableResources(identifiableModels)
codeGen.generateHibernateValidators(identifiableModels)
codeGen.generateCounterSequence(identifiableModels)

def relationships = new JsonSlurper().parse(new FileReader("${project.basedir}/../model/relationships.json"))
//codeGen.generateRelationshipResources(relationships)
//codeGen.generateRelationshipSpringDataRepositories(relationships)