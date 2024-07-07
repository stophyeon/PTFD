package org.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Chat {
    private Long roomId;
    private String name;
    private List<Message> messages;

    @Builder
    public Chat(Long roomId, String name, List<Message> messages){
        this.messages=messages;
        this.name=name;
        this.roomId=roomId;
    }
}
