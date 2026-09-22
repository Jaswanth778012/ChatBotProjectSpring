package com.kodnest.chatbotproject.service;

import com.kodnest.chatbotproject.entity.Ticket;
import com.kodnest.chatbotproject.repository.TicketRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Data
public class TicketService {

    private TicketRepository repo;

    TicketService(TicketRepository repo) {
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

    public Ticket getTicketById(Long TicketId) {
        return repo.findTicketById(TicketId).orElse(null);
    }

    public Ticket getTicketByEmailId(String emailId) {
            return  repo.findByEmail(emailId).orElse(null);
    }


}
