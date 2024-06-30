package org.example.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ChatRoomDto {
    private Long roomId;
    private String roomName;

    @Builder
    public ChatRoomDto(Long roomId,String roomName){
        this.roomId=roomId;
        this.roomName=roomName;
    }
}
