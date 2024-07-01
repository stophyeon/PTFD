package org.example.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ChatRoomDto {
    private Long roomId;
    private String name;

    @Builder
    public ChatRoomDto(Long roomId,String roomName){
        this.roomId=roomId;
        this.name=roomName;
    }
}
