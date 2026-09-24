package com.kodnest.chatbotproject.service;

import com.kodnest.chatbotproject.dto.TicketResponse;
import com.kodnest.chatbotproject.entity.Ticket;
import com.kodnest.chatbotproject.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Ticket createTicket(Ticket ticket) {

        return repo.save(ticket);
    }

    @Transactional
    public Ticket updateTicket(Ticket ticket) {

        return repo.save(ticket);
    }

    public Ticket getTicketById(Long ticketId) {

        return repo.findTicketById(ticketId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No ticket found with id: " + ticketId
                        )
                );
    }

    public TicketResponse getTicketByEmailId(String emailId) {

        Ticket ticket = repo.findByEmail(emailId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No ticket found for email: " + emailId
                        )
                );

        return new TicketResponse(
                ticket.getId(),
                ticket.getSummary(),
                ticket.getPriority(),
                ticket.getEmail(),
                ticket.getDescription(),
                ticket.getCategory(),
                ticket.getCreatedOn() != null
                        ? ticket.getCreatedOn().toString()
                        : null,
                ticket.getUpdatedOn() != null
                        ? ticket.getUpdatedOn().toString()
                        : null,
                ticket.getStatus()
        );
    }
}