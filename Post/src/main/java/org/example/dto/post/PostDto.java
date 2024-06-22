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
    private String email;
    private String image_post;
    private String post_info;
    private int total_number;
    float f = 0.2f;

    private int state;

    private int category_id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate start_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end_at;
    private boolean like=false;
    private String nick_name;
    private String userProfile;
    private String credit;
    @Builder
    public PostDto(String credit,Long post_id,String nick_name,String post_name, int price, LocalDate start_at, LocalDate end_at, String image_post, String post_info,int total_number, int category_id, String userProfile,int state,String email,boolean like){
        this.category_id=category_id;
        this.start_at=start_at;
        this.image_post=image_post;
        this.post_name=post_name;
        this.end_at=end_at;
        this.price=price;
        this.credit=credit;
        this.post_info=post_info;
        this.total_number=total_number;
        this.nick_name=nick_name;
        this.post_id=post_id;
        this.userProfile=userProfile;
        this.state=state;
        this.like=like;
        this.email=email;
    }
    public static PostDto ToDto(Post post){
        return PostDto.builder()
                .nick_name(post.getNickName())
                .post_id(post.getPostId())
                .category_id(post.getCategoryId())
                .end_at(post.getEndAt())
                .start_at(post.getStartAt())
                .image_post(post.getImagePost())
                .total_number(post.getTotalNumber())
                .post_info(post.getPostInfo())
                .post_name(post.getPostName())
                .price(post.getPrice())
                .userProfile(post.getUserProfile())
                .state(post.getState())
                .email(post.getEmail())
                .credit(post.getCredit())
                .build();
    }

}
