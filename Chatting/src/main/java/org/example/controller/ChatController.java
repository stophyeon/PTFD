package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.apache.kafka.common.protocol.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/kafka")
public class ChatController {
    private final KafkaTemplate<String, Message> kafkaTemplate;
    @PostMapping(value = "/publish")
    public void sendMessage(@RequestBody Message message) {
        log.info("Produce message : " + message.toString());

        try {
            kafkaTemplate.send("chat", message).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public Message broadcastGroupMessage(@Payload Message message) {
        return message;
    }



}
