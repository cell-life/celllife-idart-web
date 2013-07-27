import org.celllife.idart.codegen.CodeGenerator

def codeGen = new CodeGenerator(
        groovySourcesDirectory: "${project.basedir}/src/main/groovy",
        javaSourcesDirectory: "${project.basedir}/src/main/java",
        basePackageName: project.groupId
)

def codeableModels = [
        [entityName: "AdministrationMethod", resourcePath: "methods"],
        [entityName: "Form"],
        [entityName: "RouteOfAdministration", entityNamePlural: "RoutesOfAdministration", resourcePath: "routes"],
        [entityName: "UnitOfMeasure", entityNamePlural: "UnitsOfMeasure"]
]

codeGen.generateCodeableSpringDataRepositories(codeableModels)
codeGen.generateCodeableResources(codeableModels)
codeGen.generateHibernateValidator(codeableModels)

def identifiableModels = [
        [entityName: "Clinic"],
        [entityName: "Dispensation"],
        [entityName: "Encounter"],
        [entityName: "Medication"],
        [entityName: "Patient"],
        [entityName: "Person", entityNamePlural: "People"],
        [entityName: "Prescription"],
        [entityName: "Practitioner"],
        [entityPackage: "product", entityName: "Good"],
        [entityPackage: "organisation", entityName: "LegalOrganisation"],
        [entityName: "Compound"],
        [entityName: "Drug"]
]

codeGen.generateIdentifiableSpringDataRepositories(identifiableModels)
codeGen.generateIdentifiableResources(identifiableModels)
codeGen.generateHibernateValidator(identifiableModels)
codeGen.generateCounterSequence(identifiableModels)

def abstractModels = [
        [entityPackage: "part", entityName: "FinishedGood"],
        [entityPackage: "part", entityName: "RawMaterial"],
]
codeGen.generateIdentifiableSpringDataRepositories(abstractModels)

def relationships = [
        [entities: [[name: "Clinic"], [name: "Medication"]]],
        [entities: [[name: "Clinic"], [name: "Patient"]]] ,
        [entities: [[name: "Clinic"], [name: "Practitioner"]]],
        [entities: [[name: "Clinic"], [name: "Prescription"]]]
]
codeGen.generateRelationshipResources(relationships)
codeGen.generateRelationshipSpringDataRepositories(relationships)