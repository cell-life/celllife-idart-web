package org.celllife.idart.interfaces.service.practitioner

import groovyx.net.http.ContentType
import org.celllife.idart.framework.json.JSON

import static org.celllife.idart.framework.rest.REST.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h47
 */
class PractitionerService {

    static String baseTestDataLocation = "/data/practitioner"

    static String baseResourceUrl = "${contextPath}/service/practitioners"

    static String findByClinicIdentifierUrl = "${baseResourceUrl}/search/findByClinicIdentifier"

    static findAll() {
        get(path: baseResourceUrl)
    }

    static findByClinicIdentifier(String applicationId, String clinicIdentifier) {
        get(
                path: findByClinicIdentifierUrl,
                query: [clinicIdentifier: clinicIdentifier],
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

    static post(Object practitioner) {
        post(
                path: baseResourceUrl,
                body: practitioner,
                requestContentType: ContentType.JSON
        )
    }

    static testPractitioner(String id = "0000") {
        JSON.readFromClasspath("${baseTestDataLocation}/${id}.json")
    }

}
