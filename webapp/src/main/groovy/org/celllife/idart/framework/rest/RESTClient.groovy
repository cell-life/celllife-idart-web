package org.celllife.idart.framework.rest

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-03
 * Time: 13h23
 */
@Component("restClient")
class RESTClient {

    @Value('${internal.username}')
    String username

    @Value('${internal.password}')
    String password

    def get(String uri) {

        def client = new groovyx.net.http.RESTClient(uri)
        client.auth.basic("internal", "password")

        return client.get([:]).data
    }

    def get(String uri, Map<String, Object> query) {

        def client = new groovyx.net.http.RESTClient(uri)
        client.auth.basic("internal", "password")

        return client.get(query: query).data
    }
}
