package org.celllife.idart.infrastructure.camel

import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.common.EventHeader
import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserEvent
import org.celllife.idart.domain.user.UserEventPublisher
import org.celllife.idart.domain.user.UserEventType
import org.springframework.stereotype.Component

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h23
 */
@Component class CamelUserEventPublisher implements UserEventPublisher {

    @EndpointInject(uri = "direct:userEvent") ProducerTemplate producerTemplate

    @Override
    void publish(UserEvent userEvent) {
        producerTemplate.sendBody(userEvent)
    }
}
