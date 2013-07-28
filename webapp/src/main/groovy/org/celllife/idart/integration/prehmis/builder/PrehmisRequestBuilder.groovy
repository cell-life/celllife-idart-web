package org.celllife.idart.integration.prehmis.builder

import groovy.text.SimpleTemplateEngine

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h28
 */
class PrehmisRequestBuilder {

    static engine = new SimpleTemplateEngine()

    static buildApiLoginRequest(args) {
        build("/templates/prehmis/apiLogin.xml", args)
    }

    static buildGetDrugListRequest(args) {
        build("/templates/prehmis/getDrugList.xml", args)
    }

    static buildGetPatientRequest(args) {
        build("/templates/prehmis/getPatient.xml", args)
    }

    static buildGetPractitionerListRequest(args) {
        build("/templates/prehmis/getPractitionerList.xml", args)
    }

    static buildStoreDispensationRequest(args) {
        build("/templates/prehmis/storeDispensation.xml", args)
    }

    static buildStorePrescriptionRequest(args) {
        build("/templates/prehmis/storePrescription.xml", args)
    }

    static build(String templateFilename, args) {

        def inputStream = PrehmisRequestBuilder.class.getResourceAsStream(templateFilename)
        def inputStreamReader = new InputStreamReader(inputStream)
        def template = engine.createTemplate(inputStreamReader).make(args)

        template.toString()
    }
}
