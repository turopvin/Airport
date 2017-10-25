package org.academy.projects.aopMonitor;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

    private final static Logger log = LoggerFactory.getLogger(ServiceMonitor.class);

    @Pointcut("within(org.academy.projects.service.flightManager.*)")
    public  void loggMethod(){

    }

    @After("loggMethod()")
    public void logServiceCall(){
        log.info("all methods in Service were done very well");
    }
}
