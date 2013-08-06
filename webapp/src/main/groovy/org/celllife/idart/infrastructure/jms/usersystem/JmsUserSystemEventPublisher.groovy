package org.celllife.idart.infrastructure.jms.usersystem

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.domain.system.System
import org.celllife.idart.domain.system.SystemEventPublisher
import org.celllife.idart.domain.usersystem.UserSystem
import org.celllife.idart.domain.usersystem.UserSystemEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component

import javax.jms.Topic

/**
 * System: Kevin W. Sewell
 * Date: 2013-08-05
 * Time: 19h05
 */
@Component class JmsUserSystemEventPublisher implements UserSystemEventPublisher {

    @Autowired ObjectMapper objectMapper

    @Autowired JmsTemplate jmsTemplate

    @Autowired Topic userSystemSavedEventTopic

    @Override
    void userSystemSaved(UserSystem userSystem) {

        def json = objectMapper.writer().writeValueAsString(userSystem)

        jmsTemplate.convertAndSend(userSystemSavedEventTopic, json)

    }
}
