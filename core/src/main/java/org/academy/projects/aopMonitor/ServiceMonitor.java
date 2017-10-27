package org.academy.projects.aopMonitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.processing.ProcessingEnvironment;

@Aspect
@Component
public class ServiceMonitor {

    private final static Logger log = LoggerFactory.getLogger(ServiceMonitor.class);

    @Pointcut("within(org.academy.projects.service.flightManager.*)")
    public  void logFlightManager(){
    }

    @Pointcut("within(org.academy.projects.service.passengerManager.*)")
    public  void logPassengerManager(){
    }

    @Pointcut("within(org.academy.projects.service.planeManager.*)")
    public void logPlaneManager(){
    }

    @Pointcut("within(org.academy.projects.service.ticketManager.*)")
    public void logTicketeManager(){
    }



    @AfterReturning("logFlightManager()&&logPassengerManager()&&logPlaneManager()")
    public void logServiceCall(JoinPoint joinPoint) {

        log.info(joinPoint.getSignature().getName()+" was called");

    }
}
