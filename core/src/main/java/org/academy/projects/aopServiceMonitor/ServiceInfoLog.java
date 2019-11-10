package org.academy.projects.aopServiceMonitor;

import org.academy.projects.service.flightManager.FlightManager;
import org.academy.projects.service.passengerManager.PassengerManager;
import org.academy.projects.service.planeManager.PlaneManager;
import org.academy.projects.service.ticketManager.TicketManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceInfoLog {

    private final static Logger log = LoggerFactory.getLogger(ServiceInfoLog.class);

    /**
     * Logging after any method in FlightManager.class
     *
     * @param joinPoint
     */
    @After("within(org.academy.projects.service.flightManager.*)")
    private void logFlightManager(JoinPoint joinPoint) {

        log.info("Method " + FlightManager.class + "." + joinPoint.getSignature().getName() + " was called");

    }

    /**
     * Logging after any method in PassengerManager.class
     *
     * @param joinPoint
     */
    @After("within(org.academy.projects.service.passengerManager.*)")
    private void logPassengerManager(JoinPoint joinPoint) {

        log.info("Method " + PassengerManager.class + "." + joinPoint.getSignature().getName() + " was called");

    }

    /**
     * Logging after any method in TicketManager.class
     *
     * @param joinPoint
     */
    @After("within(org.academy.projects.service.ticketManager.*)")
    private void logTicketManager(JoinPoint joinPoint) {

        log.info("Method " + TicketManager.class + "." + joinPoint.getSignature().getName() + " was called");

    }

    /**
     * Logging after any method in PlaneManager.class
     *
     * @param joinPoint
     */
    @After("within(org.academy.projects.service.planeManager.*)")
    private void logPlaneManager(JoinPoint joinPoint) {

        log.info("Method " + PlaneManager.class + "." + joinPoint.getSignature().getName() + " was called");

    }

}
