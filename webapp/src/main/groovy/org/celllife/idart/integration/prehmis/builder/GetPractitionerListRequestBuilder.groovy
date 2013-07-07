package org.celllife.idart.integration.prehmis.builder

import groovy.text.SimpleTemplateEngine

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h28
 */
class GetPractitionerListRequestBuilder {

    String username

    String password

    String facilityCode

    String applicationKey

    static String templateFilename = "/templates/prehmis/getPractitionerList.xml"

    static engine = new SimpleTemplateEngine()

    String build() {

        def inputStream = GetPractitionerListRequestBuilder.class.getResourceAsStream(templateFilename)
        def inputStreamReader = new InputStreamReader(inputStream)
        def template = engine.createTemplate(inputStreamReader).make([
                username: username,
                password: password,
                facilityCode: facilityCode,
                applicationKey: applicationKey
        ])

        template.toString()
    }

    GetPractitionerListRequestBuilder setUsername(String username) {
        this.username = username
        this
    }

    GetPractitionerListRequestBuilder setPassword(String password) {
        this.password = password
        this
    }

    GetPractitionerListRequestBuilder setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode
        this
    }

    GetPractitionerListRequestBuilder setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey
        this
    }
}
