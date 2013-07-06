package org.celllife.idart.domain.person

import groovyx.net.http.ContentType
import org.celllife.idart.framework.json.JSON

import static org.celllife.idart.framework.rest.REST.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 10h47
 */
class PersonResource {

    static String baseTestDataLocation = "/data/person"

    static String baseResourceUrl = "${contextPath}/api/people"

    static String findByIdentifierUrl = "${baseResourceUrl}/search/findByIdentifier"

    static findAll() {
        get(path: baseResourceUrl)
    }

    static findByIdentifier(String identifier) {
        get(path: findByIdentifierUrl, query: [identifier: identifier])
    }

    static clear() {

        def items = findAll().content
        items.each {
            item ->
                def linkToSelf = item.links.find { it.rel == 'self' }
                delete(path: linkToSelf.href)
        }
    }

    static post(Object person) {
        post(
                path: baseResourceUrl,
                body: person,
                requestContentType: ContentType.JSON
        )
    }

    static testPerson(String id = "0000") {
        JSON.readFromClasspath("${baseTestDataLocation}/${id}.json")
    }

}
