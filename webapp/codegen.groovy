import org.celllife.idart.codegen.CodeGenerator

def codeGen = new CodeGenerator(
        groovySourcesDirectory: "${project.basedir}/src/main/groovy",
        javaSourcesDirectory: "${project.basedir}/src/main/java",
        generatedSourcesDirectory: "${project.basedir}/target/generated-sources/domain",
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

def identifiableModels = [
        [entityName: "Clinic"],
        [entityPackage: "product", entityName: "Good"],
        [entityPackage: "part", entityName: "Compound"],
        [entityPackage: "part", entityName: "Drug"],
        [entityPackage: "part", entityName: "DrugGroup"],
        [entityPackage: "part", entityName: "FinishedGood"],
        [entityPackage: "part", entityName: "Part"],
        [entityPackage: "part", entityName: "RawMaterial"],
        [entityPackage: "part", entityName: "Subassembly"],
]

codeGen.generateIdentifiableSpringDataRepositories(codeableModels)
codeGen.generateIdentifiableResources(identifiableModels)