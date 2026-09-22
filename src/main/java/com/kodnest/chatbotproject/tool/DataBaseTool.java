package com.kodnest.chatbotproject.tool;

import com.kodnest.chatbotproject.entity.Ticket;
import com.kodnest.chatbotproject.service.TicketService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseTool {

    private final TicketService service;

    public DataBaseTool(TicketService service) {
        this.service = service;
    }

    @Tool(description = "Tool helps to create Ticket in Database")
    public Ticket createTicket(@ToolParam(description = "Ticket fields required to create new ticket") Ticket ticket) {
        try {
            System.out.println("going to create ticket");
            System.out.println(ticket);
            return service.createTicket(ticket);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Tool(description = "Tool helps to get the Ticket By Id")
    public Ticket getTicketById(@ToolParam(description = "Id whose Ticket is required") Long Id) {
        return service.getTicketById(Id);
    }

    @Tool(description = "Tool helps to get the Ticket By Username")
    public Ticket getTicketByEmailId(@ToolParam(description = "email id whose Ticket is required") String emailId) {
        return service.getTicketByEmailId(emailId);
    }

    @Tool(description = "Tool helps to update Ticket in Database")
    public Ticket updateTicket(@ToolParam(description = "new ticket fields are required to Update") Ticket ticket) {
        return service.updateTicket(ticket);
    }

    @Tool(description = "This tool helps to get current System time.")
    public String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }


}
