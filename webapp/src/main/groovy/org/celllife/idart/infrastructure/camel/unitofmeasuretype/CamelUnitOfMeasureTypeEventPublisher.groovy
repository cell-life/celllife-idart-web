package org.celllife.idart.infrastructure.camel.unitofmeasuretype

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeEvent
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Unit Of Measure Type Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelUnitOfMeasureTypeEventPublisher implements UnitOfMeasureTypeEventPublisher {

    @EndpointInject(uri = "direct:unitOfMeasureTypeEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(UnitOfMeasureTypeEvent unitOfMeasureTypeEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(unitOfMeasureTypeEvent))
    }
}
