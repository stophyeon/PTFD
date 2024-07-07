package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.dto.ChatRoomDto;



@Getter
@RequiredArgsConstructor
@Entity
public class ChattingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
