package org.celllife.idart.infrastructure.jms.system

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component

import javax.jms.Topic

/**
 * System: Kevin W. Sewell
 * Date: 2013-08-05
 * Time: 19h05
 */
@Component class JmsSystemEventPublisher implements SystemEventPublisher {

    @Autowired ObjectMapper objectMapper

    @Autowired JmsTemplate jmsTemplate

    @Autowired Topic systemSavedEventTopic

    @Override
    void systemSaved(System system) {

        def json = objectMapper.writer().writeValueAsString(system)

        jmsTemplate.convertAndSend(systemSavedEventTopic, json)

    }
}
