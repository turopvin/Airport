package org.academy.projects.service.ticketManager;

import org.academy.projects.model.Ticket;

import java.util.List;

public interface TicketManagement {

    /**
     * Returns created ticket
     *
     * @param ticket
     * @return
     */
    Ticket create(Ticket ticket);
}
