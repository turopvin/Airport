package org.academy.projects.aopMonitor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.processing.ProcessingEnvironment;

@Aspect
@Component
public class ServiceMonitor {

    private final static Logger log = LoggerFactory.getLogger(ServiceMonitor.class);

    @Pointcut("within(org.academy.projects.service.flightManager.*)")
    public  void loggMethod(){

    }

 /*   @Around("loggMethod()")
    public void logServiceCall(ProceedingJoinPoint joinPoint){

        String methodName = joinPoint.getSignature().getName();

        log.info("Method : "+ methodName +" returns ");



    }*/
}
