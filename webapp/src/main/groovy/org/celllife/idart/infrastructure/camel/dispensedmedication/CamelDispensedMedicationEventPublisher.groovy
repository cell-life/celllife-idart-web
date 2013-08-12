package org.celllife.idart.infrastructure.camel.dispensedmedication

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.camel.EndpointInject
import org.apache.camel.ProducerTemplate
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationEvent
import org.celllife.idart.domain.dispensedmedication.DispensedMedicationEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.Generated

/**
 * Camel DispensedMedication Event Publisher
 */
@Generated("org.celllife.idart.codegen.CodeGenerator")
@Component class CamelDispensedMedicationEventPublisher implements DispensedMedicationEventPublisher {

    @EndpointInject(uri = "direct:dispensedMedicationEvent") ProducerTemplate producerTemplate

    @Autowired ObjectMapper objectMapper

    @Override
    void publish(DispensedMedicationEvent dispensedMedicationEvent) {
        producerTemplate.sendBody(objectMapper.writeValueAsString(dispensedMedicationEvent))
    }
}
