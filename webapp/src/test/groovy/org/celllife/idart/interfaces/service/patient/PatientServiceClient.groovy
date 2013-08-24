package org.celllife.idart.interfaces.service.patient

import groovyx.net.http.ContentType
import org.celllife.idart.framework.json.JSON

import static org.celllife.idart.framework.rest.REST.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h47
 */
class PatientServiceClient {

    static String baseTestDataLocation = "/data/patient"

    static String baseResourceUrl = "${contextPath}/patients"

    static String findByIdUrl = "${baseResourceUrl}/search/findById"

    static findAll() {
        get(path: baseResourceUrl)
    }

    static findById(String applicationId, String clinicId, String patientId) {
        get(
                path: findByIdUrl,
                query: [clinicId: clinicId, patientId: patientId],
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
