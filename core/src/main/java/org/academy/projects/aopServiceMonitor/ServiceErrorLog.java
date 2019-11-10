package org.academy.projects.aopServiceMonitor;


import org.academy.projects.model.Plane;
import org.academy.projects.model.Ticket;
import org.academy.projects.service.flightManager.FlightManager;
import org.academy.projects.service.passengerManager.PassengerManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceErrorLog {

    private final static Logger log = LoggerFactory.getLogger(ServiceErrorLog.class);

    /**
     * Logging after exception in FlightManager.class
     *
     * @param joinPoint
     */
    @AfterThrowing("execution(* org.academy.projects.service.flightManager.FlightManager.*(..))")
    private void logFlightManager(JoinPoint joinPoint) {

        log.error("Method " + FlightManager.class + "." + joinPoint.getSignature().getName()
                + " has incorrect attribute");

    }

    /**
     * Logging after exception in PassengerManager.class
     *
     * @param joinPoint
     */
    @AfterThrowing("execution(* org.academy.projects.service.passengerManager.PassengerManager.*(..))")
    private void logPassengerManager(JoinPoint joinPoint) {

        log.error("Method " + PassengerManager.class + "." + joinPoint.getSignature().getName()
                + " has incorrect attribute");

    }

    /**
     * Logging after exception in TicketManager.class
     *
     * @param joinPoint
     */
    @AfterThrowing("execution(* org.academy.projects.service.ticketManager.TicketManager.*(..))")
    private void logTicketManager(JoinPoint joinPoint) {

        log.error("Method " + Ticket.class + "." + joinPoint.getSignature().getName()
                + " has incorrect attribute");

    }

    /**
     * Logging after exception in PlaneManager.class
     *
     * @param joinPoint
     */
    @AfterThrowing("execution(* org.academy.projects.service.planeManager.PlaneManager.*(..))")
    private void logPlaneManager(JoinPoint joinPoint) {

        log.error("Method " + Plane.class + "." + joinPoint.getSignature().getName()
                + " has incorrect attribute");

    }


}
