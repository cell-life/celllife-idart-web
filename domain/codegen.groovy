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
        [entityName: "Encounter"],
        [entityName: "Patient"],
        [entityName: "Person"],
        [entityName: "Prescription"],
        [entityName: "Practitioner"],
        [entityPackage: "product", entityName: "Good"],
        [entityPackage: "organisation", entityName: "LegalOrganisation"],
        [entityName: "Compound"],
        [entityName: "Drug"],
        [entityName: "DrugGroup"]
])