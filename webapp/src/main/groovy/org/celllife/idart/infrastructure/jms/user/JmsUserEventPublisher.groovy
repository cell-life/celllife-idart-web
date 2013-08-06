package org.celllife.idart.infrastructure.jms.user

import com.fasterxml.jackson.databind.ObjectMapper
import org.celllife.idart.domain.user.User
import org.celllife.idart.domain.user.UserEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component

import javax.jms.Topic

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-05
 * Time: 19h05
 */
@Component class JmsUserEventPublisher implements UserEventPublisher {

    @Autowired ObjectMapper objectMapper

    @Autowired JmsTemplate jmsTemplate

    @Autowired Topic userSavedEventTopic

    @Override
    void userSaved(User user) {

        def json = objectMapper.writer().writeValueAsString(user)

        jmsTemplate.convertAndSend(userSavedEventTopic, json)

    }
}
