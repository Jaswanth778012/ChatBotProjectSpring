package com.kodnest.chatbotproject.controller;

import com.kodnest.chatbotproject.service.AIService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class AiController {
    private final AIService service;

    AiController(AIService service) {
        this.service = service;
    }

    @PostMapping("/response")
    public ResponseEntity<String> getResponse(@RequestBody String query, @RequestHeader("ConversationId") String conversationId) {
        return ResponseEntity.ok(service.getResponseFromAssistant(query,conversationId));
    }
}
