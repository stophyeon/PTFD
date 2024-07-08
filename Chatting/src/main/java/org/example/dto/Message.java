package org.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Message implements Serializable {
    private MessageType type;
    private String sender;
    private LocalDateTime sendAt;
    private String message;
    private Long roomId;
    private int read;

    @Builder
    public Message(String sender, LocalDateTime sendAt, String message, Long roomId, MessageType type, int read){
        this.message=message;
        this.sendAt=sendAt;
        this.sender=sender;
        this.roomId=roomId;
        this.type=type;
        this.read=read;
    }



}
