package com.kodnest.chatbotproject.tool;

import com.kodnest.chatbotproject.dto.TicketResponse;
import com.kodnest.chatbotproject.entity.Ticket;
import com.kodnest.chatbotproject.service.TicketService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class DataBaseTool {

    private final TicketService service;

    public DataBaseTool(TicketService service) {
        this.service = service;
    }

    @Tool(description = """
        Creates a NEW support ticket in the database.
        Use this tool ONLY when the user explicitly wants to create,
        raise, open, submit, or report a NEW support ticket.
        Do NOT use this tool to retrieve or update an existing ticket.
        """)
    public Ticket createTicket(
            @ToolParam(description = """
                Ticket fields required to create a new ticket.
                Include email, summary, description, priority,
                category, and status.
                Do not provide id, createdOn, or updatedOn.
                """)
            Ticket ticket) {

        System.out.println("=================================");
        System.out.println(">>> CREATE TICKET TOOL CALLED");
        System.out.println(">>> Ticket: " + ticket);
        System.out.println("=================================");

        return service.createTicket(ticket);
    }

    @Tool(description = """
        Retrieves an EXISTING support ticket using its ID.
        Use this tool ONLY when the user wants to view, find,
        check, or retrieve an existing ticket by ID.
        Never use this tool to create a ticket.
        """)
    public TicketResponse getTicketById(
            @ToolParam(description = "ID of an existing support ticket")
            Long id) {

        System.out.println(">>> GET TICKET BY ID TOOL CALLED: " + id);

        Ticket ticket = service.getTicketById(id);

        return convertToResponse(ticket);
    }

    @Tool(description = """
        Retrieves an EXISTING support ticket using the customer's email.
        Use this tool ONLY when the user wants to check, find, view,
        track, or retrieve an existing ticket.
        Never use this tool when the user wants to create a new ticket.
        """)
    public TicketResponse getTicketByEmailId(
            @ToolParam(description = "Email address associated with an existing ticket")
            String emailId) {

        System.out.println(">>> GET TICKET BY EMAIL TOOL CALLED: " + emailId);

        return service.getTicketByEmailId(emailId);
    }

    @Tool(description = """
        Updates an EXISTING support ticket.
        Use this tool ONLY when the user explicitly wants to update
        or modify an existing ticket.
        Never use this tool to create a new ticket.
        """)
    public Ticket updateTicket(
            @ToolParam(description = "Existing ticket information to update")
            Ticket ticket) {

        System.out.println(">>> UPDATE TICKET TOOL CALLED");
        System.out.println(">>> Ticket: " + ticket);

        return service.updateTicket(ticket);
    }

    @Tool(description = "Get the current system time")
    public String getCurrentTime() {

        return String.valueOf(System.currentTimeMillis());
    }

    private TicketResponse convertToResponse(Ticket ticket) {

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