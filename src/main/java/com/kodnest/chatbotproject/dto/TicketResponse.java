package com.kodnest.chatbotproject.dto;

import com.kodnest.chatbotproject.entity.Priority;
import com.kodnest.chatbotproject.entity.Status;

public record TicketResponse(
        long id,
        String summary,
        Priority priority,
        String email,
        String description,
        String category,
        String createdOn,
        String updatedOn,
        Status status
) {
}