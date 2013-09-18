package org.celllife.idart.infrastructure.camel.unitofmeasuretype

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeEvent
import org.celllife.idart.domain.unitofmeasuretype.UnitOfMeasureTypeEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Unit Of Measure Type Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelUnitOfMeasureTypeEventPublisher implements UnitOfMeasureTypeEventPublisher {

    @EndpointInject(uri = "direct:unitOfMeasureTypeEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(UnitOfMeasureTypeEvent unitOfMeasureTypeEvent) {

        unitOfMeasureTypeEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(unitOfMeasureTypeEvent))
    }
}
