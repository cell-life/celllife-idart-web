package org.celllife.idart.infrastructure.camel.unitofmeasure

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureEvent
import org.celllife.idart.domain.unitofmeasure.UnitOfMeasureEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Unit Of Measure Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelUnitOfMeasureEventPublisher implements UnitOfMeasureEventPublisher {

    @EndpointInject(uri = "direct:unitOfMeasureEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(UnitOfMeasureEvent unitOfMeasureEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(unitOfMeasureEvent))
    }
}
