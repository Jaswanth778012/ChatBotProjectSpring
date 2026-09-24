package com.kodnest.chatbotproject.controller;

import com.kodnest.chatbotproject.entity.Priority;
import com.kodnest.chatbotproject.entity.Status;
import com.kodnest.chatbotproject.entity.Ticket;
import com.kodnest.chatbotproject.service.AIService;
import com.kodnest.chatbotproject.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public class AiController {
    private final AIService service;
    private final TicketService service2;

    AiController(AIService service, TicketService service2) {
        this.service = service; this.service2 = service2;
    }

    @PostMapping("/response")
    public ResponseEntity<String> getResponse(@RequestBody String query, @RequestHeader("ConversationId") String conversationId) {
        return ResponseEntity.ok(service.getResponseFromAssistant(query,conversationId));
    }

    @PostMapping("/stream")
    public Flux<String> streamResponse(@RequestBody  String query, @RequestHeader("ConversationId") String conversationId){
        return this.service.getStreamResponseFromAssistant(query,conversationId) ;
    }

    @PostMapping("/test-ticket")
    public Ticket testTicket() {

        Ticket ticket = new Ticket();

        ticket.setSummary("Test ticket");
        ticket.setPriority(Priority.HIGH);
        ticket.setEmail("pothinajaswanthkumar@gmail.com");
        ticket.setDescription("Testing ticket creation");
        ticket.setCategory("Technical");
        ticket.setStatus(Status.OPEN);

        return service2.createTicket(ticket);
    }
}
