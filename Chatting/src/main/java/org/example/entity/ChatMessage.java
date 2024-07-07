package org.example.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.dto.Message;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@RequiredArgsConstructor
@Document(collection = "message")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private LocalDate sendAt;
    private String sender;
    private Long roomId;
    private String message;
    private int read;

    @Builder
    public ChatMessage(Long messageId, LocalDate sendAt, String sender, Long roomId, String message, int read){
        this.message=message;
        this.sender=sender;
        this.sendAt=sendAt;
        this.roomId=roomId;
        this.read=read;
    }

    public static Message toDto(ChatMessage message){
        return Message.builder()
                .message(message.getMessage())
                .sendAt(message.getSendAt())
                .sender(message.getSender())
                .read(message.getRead())
                .build();
    }

}
