package org.celllife.idart.integration.prehmis.builder

import groovy.text.SimpleTemplateEngine
import org.celllife.idart.integration.prehmis.PrehmisPatientIdentifierType

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 15h28
 */
class GetPatientRequestBuilder {

    String username

    String password

    String facilityCode

    String applicationKey

    String patientIdentifierValue

    PrehmisPatientIdentifierType patientIdentifierType

    static String templateFilename = "/templates/prehmis/getPatient.xml"

    static engine = new SimpleTemplateEngine()

    String build() {

        def inputStream = GetPatientRequestBuilder.class.getResourceAsStream(templateFilename)
        def inputStreamReader = new InputStreamReader(inputStream)
        def template = engine.createTemplate(inputStreamReader).make([
                username: username,
                password: password,
                facilityCode: facilityCode,
                applicationKey: applicationKey,
                patientIdentifierValue: patientIdentifierValue,
                patientIdentifierType: patientIdentifierType.toString().toLowerCase(),
        ])

        template.toString()
    }

    GetPatientRequestBuilder setUsername(String username) {
        this.username = username
        this
    }

    GetPatientRequestBuilder setPassword(String password) {
        this.password = password
        this
    }

    GetPatientRequestBuilder setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode
        this
    }

    GetPatientRequestBuilder setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey
        this
    }

    GetPatientRequestBuilder setPatientIdentifierValue(String patientIdentifierValue) {
        this.patientIdentifierValue = patientIdentifierValue
        this
    }

    GetPatientRequestBuilder setPatientIdentifierType(PrehmisPatientIdentifierType patientIdentifierType) {
        this.patientIdentifierType = patientIdentifierType
        this
    }
}
