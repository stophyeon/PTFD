package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.Chat;
import org.example.dto.ChatRoomDto;
import org.example.dto.Message;
import org.example.entity.ChatMessage;
import org.example.entity.ChattingRoom;
import org.example.repository.ChatRoomRepository;
import org.example.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final MessageRepository messageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public void saveMsg(Message msg){
        ChatMessage message= Message.toEntity(msg);
        messageRepository.save(message);
    }

    public List<ChatRoomDto> findRooms(){

        return chatRoomRepository.findAll().stream().map(ChattingRoom::toDto).toList();
    }

    public ChatRoomDto makeRoom(String roomName){
        ChattingRoom chatRoom=chatRoomRepository.save(ChattingRoom.createRoom(roomName));
        return ChatRoomDto.builder().roomName(chatRoom.getRoomName()).roomId(chatRoom.getRoomId()).build();
    }

    public Chat getRoomById(Long roomId){
        ChattingRoom room =chatRoomRepository.findByRoomId(roomId);
        List<ChatMessage> messages = messageRepository.findAllByRoomId(roomId);

        return Chat.builder()
                .name(room.getRoomName())
                .roomId(room.getRoomId())
                .messages(messages.stream().map(ChatMessage::toDto).toList())
                .build();
    }
    public List<Message> getMessages(String roomId){
        return messageRepository.findAllByRoomId(Long.parseLong(roomId)).stream().map(ChatMessage::toDto).toList();
    }






}
