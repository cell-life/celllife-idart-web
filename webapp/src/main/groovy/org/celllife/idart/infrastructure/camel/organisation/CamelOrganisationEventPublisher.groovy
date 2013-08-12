package org.celllife.idart.infrastructure.camel.organisation

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.organisation.OrganisationEvent
import org.celllife.idart.domain.organisation.OrganisationEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel Organisation Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelOrganisationEventPublisher implements OrganisationEventPublisher {

    @EndpointInject(uri = "direct:organisationEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(OrganisationEvent organisationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(organisationEvent))
    }
}
