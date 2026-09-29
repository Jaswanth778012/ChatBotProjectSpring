package com.kodnest.chatbotproject.config;

import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.LogManager;

@Configuration
public class AiConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public ChatMemory chatmemo(JdbcChatMemoryRepository repo) {
        return MessageWindowChatMemory
                .builder()
                .chatMemoryRepository(repo)
                .maxMessages(10)
                .build();
    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory memory) {
        logger.info("ChatClient is created");
        logger.info("chat memory is created {}",memory.getClass().getName());
        MessageChatMemoryAdvisor messageMemory = MessageChatMemoryAdvisor.builder(memory).build();

        return builder
                .defaultSystem("Summerize the response within 400 words")
                .defaultAdvisors(messageMemory,new SimpleLoggerAdvisor())
                .build();
    }
}
