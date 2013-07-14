package org.celllife.idart.domain.assignment

import groovyx.net.http.ContentType
import org.celllife.idart.framework.json.JSON

import static org.celllife.idart.framework.rest.REST.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 13h29
 */
class AssignmentResource {

    static String baseTestDataLocation = "/data/assignment"

    static String baseResourceUrl = "${contextPath}/api/assignments"

    static findAll() {
        get(path: baseResourceUrl)
    }

    static clear() {

        def items = findAll().content
        items.each { item ->
                def linkToSelf = item.links.find { it.rel == 'self' }
                delete(path: linkToSelf.href)
        }
    }

    static post(Object assignment) {
        post(
                path: baseResourceUrl,
                body: assignment,
                requestContentType: ContentType.JSON
        )
    }

    static testAssignment(String id = "0000") {
        JSON.readFromClasspath("${baseTestDataLocation}/${id}.json")
    }

}
