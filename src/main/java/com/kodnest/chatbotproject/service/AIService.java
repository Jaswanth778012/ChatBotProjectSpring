package com.kodnest.chatbotproject.service;

import com.kodnest.chatbotproject.tool.DataBaseTool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@Data
public class AIService {
    private final ChatClient chatClient;

    private final DataBaseTool tool;

    @Value("classpath:/help-desk.st")
    private Resource systemPromptResource;

    public AIService(ChatClient chatClient, DataBaseTool tool) {
        this.chatClient = chatClient;
        this.tool = tool;
    }

    public String getResponseFromAssistant(String query, String conversationalId) {
        return this.chatClient
                .prompt()
                .system(systemPromptResource)
                .tools(tool)
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,conversationalId))
                .user(query)
                .call()
                .content();
    }
}
