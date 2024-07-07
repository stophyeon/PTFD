package org.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.entity.ChatMessage;


import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class Message implements Serializable {
    private MessageType type;
    private String sender;
    private LocalDate sendAt;
    private String message;
    private Long roomId;
    private int read;

    @Builder
    public Message(String sender, LocalDate sendAt, String message, Long roomId, MessageType type, int read){
        this.message=message;
        this.sendAt=sendAt;
        this.sender=sender;
        this.roomId=roomId;
        this.type=type;
        this.read=read;
    }
    public static ChatMessage toEntity(Message messageDto){
        return ChatMessage.builder()
                .message(messageDto.getMessage())
                .sendAt(messageDto.getSendAt())
                .sender(messageDto.getSender())
                .roomId(messageDto.getRoomId())
                .read(messageDto.getRead())
                .build();
    }


}
