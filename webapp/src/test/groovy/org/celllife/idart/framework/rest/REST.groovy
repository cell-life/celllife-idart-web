package org.celllife.idart.framework.rest

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 14h39
 */
class REST {

    static String contextPath = "/idart"

    static String baseUrl = "http://localhost:9000"

    static groovyx.net.http.RESTClient client = new groovyx.net.http.RESTClient(baseUrl)

    static {
        client.auth.basic("user@test.cell-life.org", "P@ssw0rd1")
    }

    static get(Map<String, ?> args) {
        def response = client.get(args)
        return response.data
    }

    static get(Map<String, ?> args, Closure closure) {
        def response = client.get(args, closure)
        return response.data
    }

    static post(Map<String, ?> args) {
        def response = client.post(args)
        return response.data
    }

    static delete(Map<String, ?> args) {
        def response = client.delete(args)
        return response.data
    }
}
