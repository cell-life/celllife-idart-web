package org.celllife.idart.test

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 10h32
 */
@Configuration
@ImportResource([
"classpath:/META-INF/spring/spring-aop.xml",
"classpath:/META-INF/spring/spring-application.xml",
"classpath:/META-INF/spring/spring-cache.xml",
"classpath:/META-INF/spring/spring-config.xml",
"classpath:/META-INF/spring/spring-domain.xml",
"classpath:/META-INF/spring/spring-dozer.xml",
"classpath:/META-INF/spring/spring-framework.xml",
"classpath:/META-INF/spring/spring-infrastructure-sequence.xml",
"classpath:/META-INF/spring/spring-integration-prehmis.xml",
"classpath:/META-INF/spring/spring-integration-ucum.xml",
"classpath:/META-INF/spring/spring-jdbc.xml",
"classpath:/META-INF/spring/spring-json.xml",
"classpath:/META-INF/spring/spring-orm.xml",
"classpath:/META-INF/spring/spring-task.xml",
"classpath:/META-INF/spring/spring-tx.xml",
"classpath:/META-INF/spring-data/spring-data-jpa.xml"
])
class TestConfiguration {
}