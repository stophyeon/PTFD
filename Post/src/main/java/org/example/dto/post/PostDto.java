package org.example.dto.post;

import lombok.*;
import org.example.entity.Post;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor

public class PostDto {

    private Long post_id;

    private String post_name;

    private int price;
    private String userEmail;
    private String image_Post;
    private String image_real;
    float f = 0.2f;

    private int state;

    private int category_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate create_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expire_at;
    private boolean like=false;
    private String nick_name;
    private String userProfile;
    @Builder
    public PostDto(Long post_id,String nick_name,String post_name, int price, LocalDate create_at, LocalDate expire_at, String image_Post, String image_real, int category_id, String userProfile,int state,String userEmail,boolean like){
        this.category_id=category_id;
        this.expire_at=expire_at;
        this.image_Post=image_Post;
        this.post_name=post_name;
        this.create_at=create_at;
        this.price=price;
        this.image_real=image_real;
        this.nick_name=nick_name;
        this.post_id=post_id;
        this.userProfile=userProfile;
        this.state=state;
        this.like=like;
        this.userEmail=userEmail;
    }
    public static PostDto ToDto(Post post){
        return PostDto.builder()
                .nick_name(post.getNickName())
                .post_id(post.getPostId())
                .category_id(post.getCategoryId())
                .expire_at(post.getExpireAt())
                .create_at(post.getCreateAt())
                .image_Post(post.getImagePost())
                .image_real(post.getImageReal())
                .post_name(post.getPostName())
                .price(post.getPrice())
                .userProfile(post.getUserProfile())
                .state(post.getState())
                .userEmail(post.getUserEmail())
                .build();
    }

}
