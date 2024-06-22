package org.example.entity;

import org.example.dto.post.PostDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@RequiredArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId ;

    private String postName;

    private int price;

    private String imagePost;

    private String credit;

    private LocalDate startAt;

    private int state=1;

    private int categoryId;

    private LocalDate endAt;

    private String nickName;

    private String email;

    private String userProfile;

    private int totalNumber;

    private String postInfo;

    @Builder
    public Post(String credit,Long postId,String postName, int price, String imagePost, String postInfo,int totalNumber, LocalDate startAt, int categoryId, LocalDate endAt, String nickName,String userProfile, String email) {
        this.postId=postId;
        this.postName = postName;
        this.price = price;
        this.imagePost = imagePost;
        this.postInfo=postInfo;
        this.totalNumber=totalNumber;
        this.startAt = startAt;
        this.categoryId = categoryId;
        this.endAt = endAt;
        this.nickName = nickName;
        this.email = email;
        this.userProfile=userProfile;
        this.credit=credit;
    }



    public static Post ToEntity(PostDto postDto,String email){
        return Post.builder()
                .postInfo(postDto.getPost_info())
                .totalNumber(postDto.getTotal_number())
                .categoryId(postDto.getCategory_id())
                .postName(postDto.getPost_name())
                .startAt(postDto.getStart_at())
                .endAt(postDto.getEnd_at())
                .nickName(postDto.getNick_name())
                .email(email)
                .credit(postDto.getCredit())
                .price(postDto.getPrice())
                .imagePost(postDto.getImage_post())
                .userProfile(postDto.getUserProfile())
                .build();
    }





}
