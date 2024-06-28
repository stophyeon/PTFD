package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ChatDto;
import org.example.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChattingRoomController {
    private final ChatService chatService;


}
