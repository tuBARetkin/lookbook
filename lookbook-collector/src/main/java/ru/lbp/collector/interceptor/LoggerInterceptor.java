package ru.lbp.collector.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: NGorelov
 * Date: 22.05.13
 * Time: 18:42
 */
@Aspect
public class LoggerInterceptor {
    @Pointcut("target(ru.lbp.collector.iterator.WebPageIterator) && @annotation(ru.lbp.collector.annotations.LogRequired)")
    public void webPageIteratorLogRequired() {
    }

    @Around("webPageIteratorLogRequired()")
    public Object aroundWebPageIteratorMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        logger.info("Try to get next page");
        Object methodInvocation = invokeTargetMethod(joinPoint, "Error on getting next page", logger);
        logger.info("Next page returned successfully");

        return methodInvocation;
    }

    private Object invokeTargetMethod(ProceedingJoinPoint joinPoint, String errorMsg, Logger logger) throws Throwable {
        Object invokeMethod = null;
        try {
            invokeMethod = joinPoint.proceed();
        } catch (Throwable t) {
            logger.error(errorMsg, t);
            throw t;
        }

        return invokeMethod;
    }
}
