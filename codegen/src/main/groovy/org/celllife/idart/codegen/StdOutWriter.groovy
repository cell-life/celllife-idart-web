package org.celllife.idart.codegen

import groovy.text.SimpleTemplateEngine

/**
 * User: Kevin W. Sewell
 * Date: 2013-07-20
 * Time: 20h33
 */
class StdOutWriter {

    static void toStdOut(args) {

        def writer = new OutputStreamWriter(System.out)

        def engine = new SimpleTemplateEngine()
        def template = engine.createTemplate(new InputStreamReader(FileWriter.class.getResourceAsStream(args.templateReader)))
        def make = template.make(args.model)

        make.writeTo(writer)
    }
}
