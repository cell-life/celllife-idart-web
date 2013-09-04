package org.celllife.idart.infrastructure.camel.unitofmeasure

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureEvent
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Unit Of Measure Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelUnitOfMeasureEventPublisher implements UnitOfMeasureEventPublisher {

    @EndpointInject(uri = "direct:unitOfMeasureEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(UnitOfMeasureEvent unitOfMeasureEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(unitOfMeasureEvent))
    }
}
