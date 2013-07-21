package org.celllife.idart.codegen

import groovy.text.SimpleTemplateEngine

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h33
 */
class Output {

    static void toFile(args) {

        new File(args.directory).mkdirs()

        def file = new File("${args.directory}/${args.fileName}")

        if (file.exists() && args.overwrite != null && !args.overwrite) {
            return
        }

        def writer = new FileWriter(file)

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(new InputStreamReader(Output.class.getResourceAsStream(args.templateReader)))
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
