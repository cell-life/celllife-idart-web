package org.celllife.idart.codegen

import groovy.text.SimpleTemplateEngine

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h33
 */
class FileWriter {

    static void toFile(args) {

        new File(args.directory).mkdirs()

        def file = new File("${args.directory}/${args.fileName}")

//        println "About to write ${args.directory}/${args.fileName}"

        if (file.exists() && !file.text.contains("@Generated(\"org.celllife.idart.codegen.CodeGenerator\")")) {
            return
        }

//        println "About to writing ${args.directory}/${args.fileName}"

        def writer = new java.io.FileWriter(file)

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(new InputStreamReader(FileWriter.class.getResourceAsStream(args.templateReader)))
        def make = template.make(args.model)
        make.writeTo(writer)
    }

    static void toString(args) {
        def writer = new StringWriter()

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(args.templateReader)
        def make = template.make(args.model)
        make.writeTo(writer)

        writer.toString()
    }
}
