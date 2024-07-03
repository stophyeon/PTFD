package org.example.entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.dto.ChatRoomDto;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ChattingRoom")
@Getter
@RequiredArgsConstructor

public class ChattingRoom {
    @Id
    private Long roomId;

    private String roomName;

    @Builder
    public ChattingRoom(String roomName){
        this.roomName=roomName;
    }
    public static  ChattingRoom createRoom(String roomName){
        return ChattingRoom.builder().roomName(roomName).build();
    }
    public static ChatRoomDto toDto(ChattingRoom room){
        return ChatRoomDto.builder()
                .roomId(room.getRoomId())
                .roomName(room.roomName)
                .build();
    }


}
