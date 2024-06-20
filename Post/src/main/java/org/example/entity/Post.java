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
    @Column(name = "image_real")
    private String ImageReal;


    @Column(name = "create_at")
    private LocalDate createAt;

    @Column(name="state")
    private int state=1;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "expiration_at")
    private LocalDate expireAt;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_profile")
    private String userProfile;


    @Builder
    public Post(Long postId,String postName, int price, String imagePost, String imageReal, LocalDate createAt, int categoryId, LocalDate expireAt, String nickName,String userProfile, String userEmail,int state) {
        this.postId=postId;
        this.postName = postName;
        this.price = price;
        this.ImagePost = imagePost;
        this.ImageReal = imageReal;
        this.createAt = createAt;
        this.categoryId = categoryId;
        this.expireAt = expireAt;
        this.nickName = nickName;
        this.userEmail = userEmail;
        this.userProfile=userProfile;
    }



    public static Post ToEntity(PostDto postDto,String userEmail){
        return Post.builder()
                .categoryId(postDto.getCategory_id())
                .postName(postDto.getPost_name())
                .createAt(postDto.getCreate_at())
                .expireAt(postDto.getExpire_at())
                .nickName(postDto.getNick_name())
                .userEmail(userEmail)
                .price(postDto.getPrice())
                .imagePost(postDto.getImage_Post())
                .imageReal(postDto.getImage_real())
                .userProfile(postDto.getUserProfile())
                .build();
    }





}
