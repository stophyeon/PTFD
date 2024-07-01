package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ChatRoomDto;
import org.example.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatService chatService;
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/rooms";
    }
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoomDto> getRooms(){
        return chatService.findRooms();
    }
    @PostMapping("/room")
    @ResponseBody
    public ChatRoomDto createRoom(@RequestParam String name){
        return chatService.makeRoom(name);
    }
    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(@PathVariable String roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }

    // 특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoomDto roomInfo(@PathVariable String roomId) {
        return chatService.getRoomById(Long.parseLong(roomId));
    }
}
