package org.celllife.idart.integration.prehmis.builder

import groovy.text.SimpleTemplateEngine

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h28
 */
class GetPractitionerListRequestBuilder {

    static String templateFilename = "/templates/prehmis/getPractitionerList.xml"

    static engine = new SimpleTemplateEngine()

    static String build(Map<String, Object> args) {

        def inputStream = GetPractitionerListRequestBuilder.class.getResourceAsStream(templateFilename)
        def inputStreamReader = new InputStreamReader(inputStream)
        def template = engine.createTemplate(inputStreamReader).make(args)

        template.toString()
    }
}
