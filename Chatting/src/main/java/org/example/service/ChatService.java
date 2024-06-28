package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.ChatDto;
import org.example.dto.MessageDto;
import org.example.entity.ChattingRoom;
import org.example.entity.Message;
import org.example.repository.ChattingRoomRepository;
import org.example.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final MessageRepository messageRepository;
    private final ChattingRoomRepository chattingRoomRepository;
    public Message createChat(MessageDto messageDto,Long roomId){
        Optional<ChattingRoom> room = chattingRoomRepository.findById(roomId);
        room.orElseThrow();
        Message message=Message.builder()
                .room(room.get())
                .content(messageDto.getContent())
                .sendAt(messageDto.getSendAt())
                .sender(messageDto.getSender())
                .build();
        messageRepository.save(message);
        return message;
    }


}
