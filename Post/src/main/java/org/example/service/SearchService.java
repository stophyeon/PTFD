package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.annotation.TimeCheck;

import org.example.dto.post.PostDto;
import org.example.entity.Post;
import org.example.repository.PostRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchService {
    private final PostRepository postRepository;

    @TimeCheck
    public List<String> autoComplete(String word){
        log.info(word);
        return postRepository.findByPostName(word).stream()
                .map(Post::getPostName)
                .toList();

    }
    @TimeCheck
    public Page<PostDto> searchPost(String postName,int page){
        Pageable pageable = PageRequest.of(page, 9, Sort.by(Sort.Direction.ASC, "PostName"));
        Page<Post> Posts=postRepository.findByPostNameAndStateOrderByCreateAtDesc(postName,pageable);

        List<PostDto> p  = Posts.stream().map(PostDto::ToDto).toList();
        log.info(p.toString());
        return new PageImpl<>(p);
    }
}
