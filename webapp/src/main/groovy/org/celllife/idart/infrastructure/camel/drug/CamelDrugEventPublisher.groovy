package org.celllife.idart.infrastructure.camel.drug

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.drug.DrugEvent
import org.celllife.idart.domain.drug.DrugEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Drug Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelDrugEventPublisher implements DrugEventPublisher {

    @EndpointInject(uri = "direct:drugEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(DrugEvent drugEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(drugEvent))
    }
}
