package org.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class MessageDto {
    private MessageType type;
    private String sender;
    private LocalDate sendAt;
    private String content;

}
