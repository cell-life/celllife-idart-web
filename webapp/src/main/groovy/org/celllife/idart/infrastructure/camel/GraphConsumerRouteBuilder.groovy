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

        from("jms:topic:userSavedEventTopic?" +
                "clientId=userSavedEventGraphConsumer&" +
                "durableSubscriptionName=userSavedEventGraphConsumer"
        ).beanRef("graphDomainEventConsumer", "userSaved")

        from("jms:topic:systemSavedEventTopic?" +
                "clientId=systemSavedEventGraphConsumer&" +
                "durableSubscriptionName=systemSavedEventGraphConsumer"
        ).beanRef("graphDomainEventConsumer", "systemSaved")

        from("jms:topic:userSystemSavedEventTopic?" +
                "clientId=userSystemSavedEventGraphConsumer&" +
                "durableSubscriptionName=userSystemSavedEventGraphConsumer"
        ).beanRef("graphDomainEventConsumer", "userSystemSaved")

    }

}
