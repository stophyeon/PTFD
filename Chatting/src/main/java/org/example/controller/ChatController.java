package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.MessageDto;
import org.example.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatService chatService;

    //채팅방애 입장
    @MessageMapping("/join")
    public void joinRoom(@RequestBody MessageDto message) {
        message.setContent(message.getSender()+"님이 입장했습니다.");
        simpMessagingTemplate.convertAndSend("/sub/chat/"+message.getRoomId(),message.getContent());
    }

    @MessageMapping("/send")
    public void sendMessage(MessageDto message){
        chatService.saveMsg(message);
        simpMessagingTemplate.convertAndSend("/sub/chat/"+message.getRoomId(),message.getContent());
    }

}
