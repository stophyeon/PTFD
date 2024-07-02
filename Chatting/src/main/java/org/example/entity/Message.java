package org.example.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.dto.MessageDto;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("message")
@Getter
@RequiredArgsConstructor
public class Message {
    @Id
    private Long messageId;
    private LocalDate sendAt;
    private String sender;
    private Long roomId;
    private String message;
    private boolean read;

    @Builder
    public Message(Long messageId, LocalDate sendAt,String sender, Long roomId, String message,boolean read){
        this.message=message;
        this.sender=sender;
        this.sendAt=sendAt;
        this.roomId=roomId;
        this.read=read;
    }

    public static MessageDto toDto(Message message){
        return MessageDto.builder()
                .message(message.getMessage())
                .sendAt(message.getSendAt())
                .sender(message.getSender())
                .read(message.isRead())
                .build();
    }

}
