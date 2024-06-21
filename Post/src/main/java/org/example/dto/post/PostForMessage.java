package org.example.dto.post;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PostForMessage {
    private String post_name;


    @Builder
    public PostForMessage(String postName){

        this.post_name=postName;
    }
}
