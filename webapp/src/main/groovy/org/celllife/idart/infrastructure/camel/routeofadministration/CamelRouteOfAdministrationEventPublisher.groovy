package org.celllife.idart.infrastructure.camel.routeofadministration

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationEvent
import org.celllife.idart.domain.routeofadministration.RouteOfAdministrationEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Route Of Administration Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelRouteOfAdministrationEventPublisher implements RouteOfAdministrationEventPublisher {

    @EndpointInject(uri = "direct:routeOfAdministrationEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(RouteOfAdministrationEvent routeOfAdministrationEvent) {

        routeOfAdministrationEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(routeOfAdministrationEvent))
    }
}
