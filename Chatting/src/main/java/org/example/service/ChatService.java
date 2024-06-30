package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.ChatRoomDto;
import org.example.dto.MessageDto;
import org.example.entity.ChattingRoom;
import org.example.entity.Message;
import org.example.repository.ChatRoomRepository;
import org.example.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final MessageRepository messageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public void saveMsg(MessageDto msg){
        Message message=MessageDto.toEntity(msg);
        messageRepository.save(message);
    }

    public List<ChatRoomDto> findRooms(){

        return chatRoomRepository.findAll().stream().map(ChattingRoom::toDto).toList();
    }

    public ChatRoomDto makeRoom(ChatRoomDto room){
        ChattingRoom chatRoom=chatRoomRepository.save(ChattingRoom.createRoom(room.getRoomName()));
        return ChatRoomDto.builder().roomName(chatRoom.getRoomName()).roomId(chatRoom.getRoomId()).build();
    }







}
