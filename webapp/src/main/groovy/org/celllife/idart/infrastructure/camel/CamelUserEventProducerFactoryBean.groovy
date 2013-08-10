package org.celllife.idart.infrastructure.camel

import org.apache.camel.CamelContext
import org.apache.camel.component.bean.ProxyHelper
import org.celllife.idart.domain.user.UserEventPublisher
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import static org.apache.camel.component.bean.ProxyHelper.createProxy

/**
 * User: Kevin W. Sewell
 * Date: 2013-08-10
 * Time: 12h23
 */
@Component class CamelUserEventProducerFactoryBean implements FactoryBean<UserEventPublisher>{

    @Autowired CamelContext camelContext

    @Override
    UserEventPublisher getObject() throws Exception {
        createProxy(camelContext.getEndpoint("direct:userEvent"), UserEventPublisher)
    }

    @Override
    Class<?> getObjectType() {
        UserEventPublisher
    }

    @Override
    boolean isSingleton() {
        return true
    }
}
