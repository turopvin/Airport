package org.academy.projects.service.ticketManager;

import org.academy.projects.model.Ticket;
import org.academy.projects.repository.ticket.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TicketManager implements TicketManagement {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketManager(final TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket create(final Ticket ticket) {
        if (ticket == null) {

            throw new IllegalArgumentException("Please check your input data");
        }

        return ticketRepository.save(ticket);
    }

}
