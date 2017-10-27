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

    private final static Logger log = LoggerFactory.getLogger(TicketManager.class);

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketManager(final TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * Returns created ticket
     * @param ticket
     * @return
     */
    @Override
    public Ticket create(Ticket ticket) {
        if (ticket == null) {

            log.error("Passenger can't be null in"+TicketManager.class.getName());

            throw new IllegalArgumentException("ticket can't be null");
        }

        return ticketRepository.save(ticket);
    }

}
