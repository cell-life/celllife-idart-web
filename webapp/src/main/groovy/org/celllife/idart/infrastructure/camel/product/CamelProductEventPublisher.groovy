package org.celllife.idart.infrastructure.camel.product

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.product.ProductEvent
import org.celllife.idart.domain.product.ProductEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Product Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelProductEventPublisher implements ProductEventPublisher {

    @EndpointInject(uri = "direct:productEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(ProductEvent productEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(productEvent))
    }
}
