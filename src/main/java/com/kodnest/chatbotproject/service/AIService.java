package com.kodnest.chatbotproject.service;

import com.kodnest.chatbotproject.tool.DataBaseTool;

import com.kodnest.chatbotproject.tool.EmailTool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@Data
public class AIService {
    private final ChatClient chatClient;

    private final DataBaseTool tool;

    private final EmailTool tool2;

    @Value("classpath:/help-desk.st")
    private Resource systemPromptResource;

    public AIService(ChatClient chatClient, DataBaseTool tool, EmailTool tool2) {
        this.chatClient = chatClient;
        this.tool = tool;
        this.tool2 = tool2;
    }

    public String getResponseFromAssistant(String query, String conversationalId) {
        return this.chatClient
                .prompt()
                .system(systemPromptResource)
                .tools(tool, tool2)
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,conversationalId))
                .user(query)
                .call()
                .content();
    }

    public Flux<String> getStreamResponseFromAssistant(String query, String conversationalId) {
        return this.chatClient
                .prompt()
                .system(systemPromptResource)
                .tools(tool, tool2)
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID,conversationalId))
                .user(query)
                .stream()
                .content();
    }
}
