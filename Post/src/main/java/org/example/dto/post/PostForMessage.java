package org.example.dto.post;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PostForMessage {
    private String post_name;
    private String image_real;

    @Builder
    public PostForMessage(String postName, String image_real){
        this.image_real=image_real;
        this.post_name=postName;
    }
}
