package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ChatRoomDto;
import org.example.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatService chatService;

    @GetMapping("/rooms")
    public List<ChatRoomDto> getRooms(){
        return chatService.findRooms();
    }
    @PostMapping("/room")
    public ChatRoomDto createRoom(@RequestBody ChatRoomDto room){
        return chatService.makeRoom(room);
    }
}
