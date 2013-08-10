package org.celllife.idart.infrastructure.camel

import org.apache.camel.builder.RouteBuilder
import org.springframework.stereotype.Component

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-06
 * Time: 21h08
 */
@Component class GraphConsumerRouteBuilder extends RouteBuilder {

    @Override
    void configure() throws Exception {

        ["userEvent", "systemEvent", "userSystemEvent"].each { event ->
            from(buildUri(event)).beanRef("graphDomainEventConsumer", methodName(event))
        }
    }

    static methodName(String event) {
        event
    }

    static buildUri(event) {
        "jms:topic:${event}?clientId=${event}Graph&durableSubscriptionName=${event}Graph"
    }
}
