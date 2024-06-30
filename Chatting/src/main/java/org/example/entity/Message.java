package org.example.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.dto.MessageDto;

import java.time.LocalDate;

@Entity
@Getter
@RequiredArgsConstructor

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;
    private LocalDate sendAt;
    private String sender;
    private Long roomId;
    private String content;

    @Builder
    public Message(Long messageId, LocalDate sendAt,String sender, Long roomId, String content){
        this.content=content;
        this.sender=sender;
        this.sendAt=sendAt;
        this.roomId=roomId;

    }

}
