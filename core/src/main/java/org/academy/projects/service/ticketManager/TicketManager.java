package org.academy.projects.service.ticketManager;

import org.academy.projects.model.Ticket;
import org.academy.projects.repository.ticket.TicketRepository;
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
    public Ticket create(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("ticket can't be null");
        }
        return ticketRepository.save(ticket);
    }

}
