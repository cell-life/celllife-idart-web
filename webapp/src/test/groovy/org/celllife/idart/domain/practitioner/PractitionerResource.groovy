package org.celllife.idart.domain.practitioner

import groovyx.net.http.ContentType
import org.celllife.idart.framework.json.JSON

import static org.celllife.idart.framework.rest.REST.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 13h29
 */
class PractitionerResource {

    static String baseTestDataLocation = "/data/practitioner"

    static String baseResourceUrl = "${contextPath}/api/practitioners"

    static findAll() {
        get(path: baseResourceUrl)
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
