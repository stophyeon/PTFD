package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.annotation.TimeCheck;

import org.example.dto.post.PostDto;
import org.example.dto.post.PostWishListCountDto;
import org.example.dto.wish_list.EmailDto;
import org.example.entity.Post;
import org.example.entity.WishList;
import org.example.repository.PostRepository;
import org.example.repository.WishListRepository;
import org.example.service.member.MemberFeign;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchService {
    private final PostRepository postRepository;
    private final MemberFeign memberFeign;

    @TimeCheck
    public List<String> autoComplete(String word){
        log.info(word);
        return postRepository.findByPostName(word).stream()
                .map(Post::getPostName)
                .toList();

    }
//    @TimeCheck
//    public Page<PostDto> searchPost(String postName,int page){
//        Pageable pageable = PageRequest.of(page, 9, Sort.by(Sort.Direction.ASC, "postName"));
//        Page<Post> Posts=postRepository.findByPostNameAndStateOrderByCreateAtDesc(postName,pageable);
//        List<PostDto> p  = Posts.stream().map(PostDto::ToDto).toList();
//        log.info(p.toString());
//        return new PageImpl<>(p);
//    }
    @TimeCheck
    public Page<PostWishListCountDto> searchPost(String postName, int page, int category_id, char gender){
        int pagesize = 0;
        log.info(postName);
        if (page == 0)
        {
            pagesize = 12;
        } else {
            pagesize = 8;
        }
        Pageable pageable = PageRequest.of(page, pagesize, Sort.by(Sort.Direction.ASC, "postName"));

        if (category_id == 0 && gender == 'X')
        {
            //기본
            log.info(postName+"default");
            return postRepository.findByPostNameAndStateOrderByCreateAtDesc(postName,pageable);
        }
        else if (category_id == 0)
        {
            //성별만 조회
            List<String> nicknamelist = memberFeign.getNickNameByGender(gender);
            //멤버가 전해주는 성별 별 닉네임리스트

            List<PostWishListCountDto> filteredList = postRepository.findByPostNameAndStateOrderByCreateAtDescList(postName)
                    .stream()
                    .filter(dto -> nicknamelist.contains(dto.getNick_name()))
                    .collect(Collectors.toList());

            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), filteredList.size());

            Page<PostWishListCountDto> pageImpl = new PageImpl<>(filteredList.subList(start, end), pageable, filteredList.size());

            return pageImpl;

        }
        else if (gender == 'X')
        {
            //카테고리만 활용 조회
            Page<PostWishListCountDto> postswishlistcountdto = postRepository.findByPostNameAndStateAndCategoryIdOrderByCreateAtDesc(postName,category_id,pageable);
            return postswishlistcountdto;
        }
        else {
            // 두개 모두 활용 조회

            List<String> nicknamelist = memberFeign.getNickNameByGender(gender);
            //멤버가 전해주는 성별 별 닉네임리스트

            List<PostWishListCountDto> filteredList = postRepository.findByPostNameAndStateAndCategoryIdOrderByCreateAtDescList(postName,category_id)
                    .stream()
                    .filter(dto -> nicknamelist.contains(dto.getNick_name()))
                    .collect(Collectors.toList());

            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), filteredList.size());

            Page<PostWishListCountDto> pageImpl = new PageImpl<>(filteredList.subList(start, end), pageable, filteredList.size());

            return pageImpl;

        }

    }
}
