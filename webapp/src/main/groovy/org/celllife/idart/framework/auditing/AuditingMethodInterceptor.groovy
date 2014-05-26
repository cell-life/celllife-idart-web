package org.celllife.idart.framework.auditing

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import org.springframework.ui.Model
import org.springframework.web.servlet.mvc.support.RedirectAttributes

import java.lang.reflect.Method

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 10h15
 */
@Component class AuditingMethodInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditingMethodInterceptor.class)

    @Autowired
    private ObjectMapper objectMapper

    private String toJson(Map<String, Object> payload) {
        try {
            return objectMapper.writeValueAsString(payload)
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e)
        }
        return "ERROR"
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Method method = invocation.getMethod()

        Class<?> clazz = method.getDeclaringClass()

        String methodName = method.toGenericString()

        List<Map<String, Object>> parameters = new ArrayList<>()

        Object[] invocationArguments = invocation.getArguments()
        for (int i = 0; i < invocationArguments.length; i++) {
            Object value = invocationArguments[i]
            if (filter(value)) {
                Map<String, Object> argument = new HashMap<>()
                argument.put("type", method.getParameterTypes()[i])
                argument.put("value", value)
                parameters.add(argument)
            }
        }

        Map<String, Object> payload = new HashMap<>()

        SecurityContext securityContext = SecurityContextHolder.getContext()
        if (securityContext != null) {
            Authentication authentication = securityContext.getAuthentication()
            if (authentication != null) {
                Object principal = authentication.getPrincipal()
    
                if (principal instanceof User) {
                    payload.put("username", ((User) principal).getUsername())
                }
                if (principal instanceof String) {
                    payload.put("username", principal)
                }
            }
        }

        payload.put("class", clazz)
        payload.put("timestamp", new Date().toString())
        payload.put("method", methodName)
        payload.put("parameters", parameters)

        LOGGER.info(toJson(payload))

        return invocation.proceed()
    }

    static Boolean filter(Object value) {

        if (!(value instanceof Serializable)) {
            return false
        }

        if (value instanceof ServerHttpResponse) {
            return false
        }

        if (value instanceof ServerHttpRequest) {
            return false
        }

        if (value instanceof RedirectAttributes) {
            return false
        }

        if (value instanceof Model) {
            return false
        }

        if (value instanceof Authentication) {
            return false
        }

        return true
    }
}