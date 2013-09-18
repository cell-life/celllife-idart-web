package org.celllife.idart.infrastructure.camel.organisation

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.organisation.OrganisationEvent
import org.celllife.idart.domain.organisation.OrganisationEventPublisher

import javax.annotation.Generated
import javax.inject.Inject
import javax.inject.Named

import static org.celllife.idart.framework.security.Principals.currentUsername

/**
 * Camel Organisation Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Named class CamelOrganisationEventPublisher implements OrganisationEventPublisher {

    @EndpointInject(uri = "direct:organisationEvent") ProducerTemplate producerTemplate

    @Inject ObjectMapper objectMapper

    @Override
    void publish(OrganisationEvent organisationEvent) {

        organisationEvent.username = currentUsername

        producerTemplate.sendBody(objectMapper.writeValueAsString(organisationEvent))
    }
}
