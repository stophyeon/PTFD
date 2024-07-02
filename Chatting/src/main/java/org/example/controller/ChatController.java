package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.MessageDto;
import org.example.dto.MessageType;
import org.example.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatService chatService;

    //채팅방애 입장
    @MessageMapping("/send")
    public void joinRoom(MessageDto message) {
        if(MessageType.ENTER.equals(message.getType())){
            message.setMessage(message.getSender()+"님이 입장했습니다.");
            log.info(message.getMessage());
        }
        chatService.saveMsg(message);
        log.info(message.getSender());
        log.info(message.getRoomId().toString());
        log.info(message.getMessage());
        simpMessagingTemplate.convertAndSend("/sub/chat/" + message.getRoomId(),message);
    }



}
