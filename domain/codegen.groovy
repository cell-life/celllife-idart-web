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
        [entityName: "Medication"],
        [entityName: "Patient"],
        [entityName: "Person", entityNamePlural: "People"],
        [entityName: "Prescription"],
        [entityName: "Practitioner"],
        [entityPackage: "product", entityName: "Good"],
        [entityPackage: "organisation", entityName: "LegalOrganisation"],
        [entityName: "Compound"],
        [entityName: "Drug"]
])

def stereotypes = [
        [name: "Codeable"],
        [name: "Describable"],
        [name: "Identifiable"],
        [name: "Nameable"],
        [name: "Persistable"]
]

def valueObjects = [
        [name: "Quantity"]
]

def aggregateRoots =
    [

            [
                    aggregateRoot: [
                            name: "Clinic",
                            modifiers: [abstract: true],
                            extendFrom: [name: "Facility"]
                    ]
            ],
            [
                    aggregateRoot: [
                            name: "Facility",
                            stereotypes: ["Describable", "Identifiable", "Nameable"],
                            attributes: [
                                    [
                                            name: "area",
                                            type: [name: "Quantity"]
                                    ]
                            ]

                    ]
            ]
    ]