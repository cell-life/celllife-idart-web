import org.celllife.idart.codegen.CodeGenerator

def codeGen = new CodeGenerator(
        groovySourcesDirectory: "${project.basedir}/src/main/groovy",
        javaSourcesDirectory: "${project.basedir}/src/main/java",
        generatedSourcesDirectory: "${project.basedir}/target/generated-sources/domain",
        basePackageName: project.groupId
)

codeGen.generateCodeableAggregateRoot([
        [entityName: "AdministrationMethod", resourcePath: "methods"],
        [entityName: "Form"],
        [entityName: "RouteOfAdministration", entityNamePlural: "RoutesOfAdministration", resourcePath: "routes"],
        [entityName: "UnitOfMeasure", entityNamePlural: "UnitsOfMeasure"]
])

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

codeGen.generateRelationshipAggregateRoot([
        [entities: [[name: "Clinic"], [name: "Dispensation"]]],
        [entities: [[name: "Clinic"], [name: "Medication"]]],
        [entities: [[name: "Clinic"], [name: "Patient"]]] ,
        [entities: [[name: "Clinic"], [name: "Practitioner"]]],
        [entities: [[name: "Clinic"], [name: "Prescription"]]]
])