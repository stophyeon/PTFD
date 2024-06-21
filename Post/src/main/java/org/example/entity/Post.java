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
    @Column(name = "post_id")
    private Long postId ;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "price")
    private int price ;

    @Lob
    @Column(name = "image_Post")
    private String ImagePost;

    @Lob
    @Column(name = "credit")
    private String credit;

    @Column(name = "start_at")
    private LocalDate startAt;

    @Column(name="state")
    private int state=1;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "end_at")
    private LocalDate endAt;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "email")
    private String email;

    @Column(name = "user_profile")
    private String userProfile;

    private int totalNumber;

    private String postInfo;

    @Builder
    public Post(String credit,Long postId,String postName, int price, String imagePost, String postInfo,int totalNumber, LocalDate startAt, int categoryId, LocalDate endAt, String nickName,String userProfile, String email) {
        this.postId=postId;
        this.postName = postName;
        this.price = price;
        this.ImagePost = imagePost;
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
