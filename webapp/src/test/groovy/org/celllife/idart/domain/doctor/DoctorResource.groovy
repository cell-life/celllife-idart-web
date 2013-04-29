package org.celllife.idart.domain.doctor

import groovyx.net.http.ContentType
import org.celllife.idart.framework.json.JSON

import static org.celllife.idart.framework.rest.REST.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 13h29
 */
class DoctorResource {

    static String baseTestDataLocation = "/data/doctor"

    static String baseResourceUrl = "${contextPath}/api/doctors"

    static findAll() {
        get(path: baseResourceUrl)
    }

    static clear() {

        def items = findAll().content
        items.each {
            item ->
                def linkToSelf = item.links.find { it.rel == 'self' }
                delete(path: linkToSelf.href )
        }
    }

    static post(Object doctor) {
        post(
                path: baseResourceUrl,
                body: doctor,
                requestContentType: ContentType.JSON
        )
    }

    static testDoctor(String id = "0000") {
        JSON.readFromClasspath("${baseTestDataLocation}/${id}.json")
    }

}
