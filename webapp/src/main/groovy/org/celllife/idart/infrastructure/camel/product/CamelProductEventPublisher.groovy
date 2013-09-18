package org.celllife.idart.infrastructure.camel.product

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.product.ProductEvent
import org.celllife.idart.domain.product.ProductEventPublisher

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Product Event Publisher
 */
@Named class CamelProductEventPublisher implements ProductEventPublisher {

    @EndpointInject(uri = "direct:productEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(ProductEvent productEvent) {

        productEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(productEvent))
    }
}
