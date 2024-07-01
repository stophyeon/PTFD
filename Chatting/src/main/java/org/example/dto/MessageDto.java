package org.example.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.entity.Message;


import java.time.LocalDate;

@Data
@RequiredArgsConstructor

public class MessageDto {
    private MessageType type;
    private String sender;
    private LocalDate sendAt;
    private String message;
    private Long roomId;

    @Builder
    public MessageDto(String sender, LocalDate sendAt, String message, Long roomId,MessageType type){
        this.message=message;
        this.sendAt=sendAt;
        this.sender=sender;
        this.roomId=roomId;
        this.type=type;
    }
    public static Message toEntity(MessageDto messageDto){
        return Message.builder()
                .message(messageDto.getMessage())
                .sendAt(messageDto.getSendAt())
                .sender(messageDto.getSender())
                .roomId(messageDto.getRoomId())
                .build();
    }


}
