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
    private List<MessageDto> messages;

    @Builder
    public Chat(Long roomId, String name, List<MessageDto> messages){
        this.messages=messages;
        this.name=name;
        this.roomId=roomId;
    }
}
