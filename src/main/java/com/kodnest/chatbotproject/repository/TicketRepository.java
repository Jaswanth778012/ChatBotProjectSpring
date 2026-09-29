package com.kodnest.chatbotproject.repository;

import com.kodnest.chatbotproject.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findTicketById(Long id);
    Optional<Ticket> findByEmail(String email);
}
