package org.celllife.idart.infrastructure.camel.defaultdosageinstruction

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Default Dosage Instruction Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelDefaultDosageInstructionEventPublisher implements DefaultDosageInstructionEventPublisher {

    @EndpointInject(uri = "direct:defaultDosageInstructionEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(DefaultDosageInstructionEvent defaultDosageInstructionEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(defaultDosageInstructionEvent))
    }
}
