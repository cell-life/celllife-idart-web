package org.celllife.idart.domain.clinic

import groovyx.net.http.ContentType
import org.celllife.idart.framework.json.JSON

import static org.celllife.idart.framework.rest.REST.*

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-25
 * Time: 13h29
 */
class ClinicResource {

    static String baseTestDataLocation = "/data/clinic"

    static String baseResourceUrl = "${contextPath}/api/clinics"

    static String findOneByUsernameUrl = "${baseResourceUrl}/search/findOneByUsername"

    static findAll() {
        get(path: baseResourceUrl)
    }

    static findOneByUsername(String username) {
        get(path: findOneByUsernameUrl, query: [username: username])
    }

    static clear() {

        def items = findAll().content
        items.each {
            item ->
                def linkToSelf = item.links.find { it.rel == 'self' }
                delete(path: linkToSelf.href )
        }
    }

    static post(Object clinic) {
        post(
                path: baseResourceUrl,
                body: clinic,
                requestContentType: ContentType.JSON
        )
    }

    static testClinic(String id = "0000") {
        JSON.readFromClasspath("${baseTestDataLocation}/${id}.json")
    }

}
