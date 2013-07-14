package org.celllife.idart.integration.prehmis.builder

import groovy.text.SimpleTemplateEngine
import org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h28
 */
class GetPatientRequestBuilder {

    static String templateFilename = "/templates/prehmis/getPatient.xml"

    static engine = new SimpleTemplateEngine()

    static String build(Map<String, Object> args) {

        def inputStream = GetPatientRequestBuilder.class.getResourceAsStream(templateFilename)
        def inputStreamReader = new InputStreamReader(inputStream)
        def template = engine.createTemplate(inputStreamReader).make(args)

        template.toString()
    }
}
