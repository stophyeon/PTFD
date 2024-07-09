package org.example.entity;

import lombok.Getter;
import org.example.dto.Message;
import org.example.dto.MessageType;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "message")
public class ChatMessage {
    private MessageType type;
    private String sender;
    private LocalDateTime sendAt;
    private String message;
    private Long roomId;
    private int read;

    public static Message toDto(ChatMessage chatMessage){
        return Message.builder()
                .message(chatMessage.getMessage())
                .read(chatMessage.getRead())
                .sendAt(chatMessage.getSendAt())
                .type(chatMessage.getType())
                .sender(chatMessage.getSender())
                .roomId(chatMessage.getRoomId())
                .build();
    }
}
