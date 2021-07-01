package com.blog.blogprac.service;


import com.blog.blogprac.domain.Post;
import com.blog.blogprac.domain.PostRepository;
import com.blog.blogprac.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("NO ID")
        );
        post.update(requestDto);
        return id;
    }
}
