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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MessageDto {
    private MessageType type;
    private String sender;
    private LocalDate sendAt;
    private String content;
    private Long roomId;

    @Builder
    public MessageDto(String sender, LocalDate sendAt, String content, Long roomId,MessageType type){
        this.content=content;
        this.sendAt=sendAt;
        this.sender=sender;
        this.roomId=roomId;
        this.type=type;
    }
    public static Message toEntity(MessageDto messageDto){
        return Message.builder()
                .content(messageDto.getContent())
                .sendAt(messageDto.getSendAt())
                .sender(messageDto.getSender())
                .roomId(messageDto.getRoomId())
                .build();
    }


}
