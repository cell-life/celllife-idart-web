package org.celllife.idart.interfaces.service.patient

import groovyx.net.http.ContentType
import org.celllife.idart.framework.json.JSON

import static org.celllife.idart.framework.rest.REST.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h47
 */
class PatientService {

    static String baseTestDataLocation = "/data/patient"

    static String baseResourceUrl = "${contextPath}/service/patients"

    static String findByIdentifierUrl = "${baseResourceUrl}/search/findByIdentifier"

    static findAll() {
        get(path: baseResourceUrl)
    }

    static findByIdentifier(String applicationId, String idartClinicIdentifier, String patientIdentifier) {
        get(
                path: findByIdentifierUrl,
                query: [idartClinicIdentifier: idartClinicIdentifier, patientIdentifier: patientIdentifier],
                headers: ['X-IDART_APPLICATION_ID': applicationId]
        )
    }

    static clear() {

        def items = findAll().content
        items.each {
            item ->
                def linkToSelf = item.links.find { it.rel == 'self' }
                delete(path: linkToSelf.href)
        }
    }

    static post(Object patient) {
        post(
                path: baseResourceUrl,
                body: patient,
                requestContentType: ContentType.JSON
        )
    }

    static testPatient(String id = "0000") {
        JSON.readFromClasspath("${baseTestDataLocation}/${id}.json")
    }

}
