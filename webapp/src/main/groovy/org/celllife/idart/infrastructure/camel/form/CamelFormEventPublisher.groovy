package org.celllife.idart.infrastructure.camel.form

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.form.FormEvent
import org.celllife.idart.domain.form.FormEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

/**
 * Camel Form Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelFormEventPublisher implements FormEventPublisher {

    @EndpointInject(uri = "direct:formEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(FormEvent formEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(formEvent))
    }
}
