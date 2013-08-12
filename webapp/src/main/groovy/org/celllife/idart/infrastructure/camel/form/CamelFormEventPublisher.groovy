package org.celllife.idart.infrastructure.camel.form

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.form.FormEvent
import org.celllife.idart.domain.form.FormEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Form Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelFormEventPublisher implements FormEventPublisher {

    @EndpointInject(uri = "direct:formEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(FormEvent formEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(formEvent))
    }
}
