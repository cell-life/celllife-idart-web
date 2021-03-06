package org.celllife.idart.infrastructure.camel.defaultdosageinstruction

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEvent
import org.celllife.idart.domain.defaultdosageinstruction.DefaultDosageInstructionEventPublisher

import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Default Dosage Instruction Event Publisher
 */
@Named class CamelDefaultDosageInstructionEventPublisher implements DefaultDosageInstructionEventPublisher {

    @EndpointInject(uri = "direct:defaultDosageInstructionEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(DefaultDosageInstructionEvent defaultDosageInstructionEvent) {

        defaultDosageInstructionEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(defaultDosageInstructionEvent))
    }
}
