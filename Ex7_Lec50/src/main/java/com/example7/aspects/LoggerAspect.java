package com.example7.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

    private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

//    @Around("execution(* com.example7.services.*.*(..))")
//    public void log(ProceedingJoinPoint joinPoint) throws Throwable{
//        Instant start = Instant.now();
//        logger.info(joinPoint.getSignature().toString()+" method execution start");
//        joinPoint.proceed();
//        logger.info("method execution end");
//        Instant finish = Instant.now();
//        long timeElapsed = Duration.between(start, finish).toMillis();
//        logger.info("Time took to execute the method : "+timeElapsed+" ms");
//    }

    @Around("@annotation(com.example7.aspects.LogAspect)")
    public void logAspectAnnotation(ProceedingJoinPoint joinPoint) throws Throwable{
        Instant start = Instant.now();
        logger.info(joinPoint.getSignature().toString()+" method execution start");
        joinPoint.proceed();
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed+" ms");
    }

    @AfterThrowing(value = "execution(* com.example7.services.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
        logger.severe(ex.getMessage()+" thrown by: "+joinPoint.getSignature().toString());
    }

    @AfterReturning(value = "execution(* com.example7.services.*.*(..))", returning = "retVal")
    public void logStatus(JoinPoint joinPoint, Object retVal){
        logger.info(retVal.toString() + " returned by: " + joinPoint.getSignature().toString());
    }
}
