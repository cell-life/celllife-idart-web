package org.celllife.idart.infrastructure.camel.authority

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.authority.AuthorityEvent
import org.celllife.idart.domain.authority.AuthorityEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Authority Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelAuthorityEventPublisher implements AuthorityEventPublisher {

    @EndpointInject(uri = "direct:authorityEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(AuthorityEvent authorityEvent) {

        authorityEvent.header.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(authorityEvent))
    }
}
