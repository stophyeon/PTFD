package org.example.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.dto.member.MemberDto;
import org.hibernate.annotations.ColumnDefault;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    private String email;
    private String userName;
    private String password;
    private String nickName;
    private String image;
    @ColumnDefault("0")
    private int follower;
    @ColumnDefault("0")
    private int following;
    private int point;
    private String role;
    private int socialType; //0일반 1카카오 2네이버

    @Builder
    public Member(MemberDto memberDto){
        this.email=memberDto.getEmail();
        this.password= memberDto.getPassword();
        this.nickName= memberDto.getNickName();
        this.userName= memberDto.getUserName();
        this.image=memberDto.getImage();
        this.point= memberDto.getPoint();
        this.socialType = memberDto.getSocial_type();
    }
    public static MemberDto toDto(Member member){
        return MemberDto.builder()
                .email(member.getEmail())
                .userName(member.getUserName())
                .nickName(member.getNickName())
                .image(member.getImage())
                .follower(member.follower)
                .following(member.following)
                .point(member.getPoint())
                .build();
    }


}
