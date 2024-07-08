package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {
    @Autowired
    SimpMessagingTemplate template;

    @KafkaListener(
            topics = "chat",
            groupId = "chatting"
    )
    public void listen(Message message) {
        System.out.println("sending via kafka listener..");
        log.info(message.getMessage());
        template.convertAndSend("/topic/group", message);
    }
}
