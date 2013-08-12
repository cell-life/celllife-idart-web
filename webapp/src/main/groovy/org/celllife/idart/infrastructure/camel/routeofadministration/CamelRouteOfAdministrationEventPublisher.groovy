package org.celllife.idart.infrastructure.camel.routeofadministration

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationEvent
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Route Of Administration Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelRouteOfAdministrationEventPublisher implements RouteOfAdministrationEventPublisher {

    @EndpointInject(uri = "direct:routeOfAdministrationEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(RouteOfAdministrationEvent routeOfAdministrationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(routeOfAdministrationEvent))
    }
}
