package org.celllife.idart.infrastructure.camel.defaultdosageinstruction

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Default Dosage Instruction Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelDefaultDosageInstructionEventPublisher implements DefaultDosageInstructionEventPublisher {

    @EndpointInject(uri = "direct:defaultDosageInstructionEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(DefaultDosageInstructionEvent defaultDosageInstructionEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(defaultDosageInstructionEvent))
    }
}
