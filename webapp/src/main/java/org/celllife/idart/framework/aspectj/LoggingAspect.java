package org.celllife.idart.framework.aspectj;

import com.google.common.base.Joiner;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * User: Kevin W. Sewell
 * Date: 2013-03-18
 * Time: 10h15
 */
@Aspect
@Component
class LoggingAspect {

    @Before(value = "@annotation(loggable)", argNames = "joinPoint, loggable")
    public void before(JoinPoint joinPoint, Loggable loggable) {

        if (joinPoint == null) {
            return;
        }

        Object target = joinPoint.getTarget();
        if (target == null) {
            return;
        }

        Signature signature = joinPoint.getSignature();
        if (signature == null) {
            return;
        }
        String name = signature.getName();

        Object[] args = joinPoint.getArgs();

        Class clazz = target.getClass();

        LogLevel logLevel = loggable.value();

        String logMessage = buildLogMessage(name, args);

        log(clazz, logLevel, logMessage);
    }

    @AfterThrowing(value = "@annotation(loggable)", argNames = "joinPoint, loggable, throwable", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Loggable loggable, Throwable throwable) {

        if (joinPoint == null) {
            return;
        }

        Object target = joinPoint.getTarget();
        if (target == null) {
            return;
        }

        Class<? extends Throwable> throwableClass = throwable.getClass();

        if (Exception.class.isAssignableFrom(throwableClass)) {

            Class clazz = target.getClass();

            LogLevel logLevel = loggable.exception();

            String message = throwable.getMessage();

            log(clazz, logLevel, message, throwable);
        }
    }

    static void log(Class clazz, LogLevel logLevel, String logMessage) {

        Logger logger = LoggerFactory.getILoggerFactory().getLogger(clazz.getName());

        switch (logLevel) {
            case DEBUG:
                logger.debug(logMessage);
                break;
            case ERROR:
                logger.error(logMessage);
                break;
            case INFO:
                logger.info(logMessage);
                break;
            case TRACE:
                logger.trace(logMessage);
                break;
            case WARN:
                logger.warn(logMessage);
                break;
        }

    }

    static void log(Class clazz, LogLevel logLevel, String logMessage, Throwable throwable) {

        Logger logger = LoggerFactory.getILoggerFactory().getLogger(clazz.getName());

        switch (logLevel) {
            case DEBUG:
                logger.debug(logMessage, throwable);
                break;
            case ERROR:
                logger.error(logMessage, throwable);
                break;
            case INFO:
                logger.info(logMessage, throwable);
                break;
            case TRACE:
                logger.trace(logMessage, throwable);
                break;
            case WARN:
                logger.warn(logMessage, throwable);
                break;
        }

    }

    static String buildLogMessage(String name, Object[] args) {
        return String.format("%s(%s)", name, Joiner.on(",").join(args));
    }
}
