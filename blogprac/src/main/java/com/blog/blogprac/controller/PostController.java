package com.blog.blogprac.controller;


import com.blog.blogprac.domain.Post;
import com.blog.blogprac.domain.PostRepository;
import com.blog.blogprac.domain.PostRequestDto;
import com.blog.blogprac.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/api/post")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return  postRepository.save(post);
    }

    @GetMapping("/api/post")
    public List<Post> readPost(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/post/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.update(id,requestDto);
        return id;
    }

    @DeleteMapping("/api/post/{id}")
    public Long deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }

    @GetMapping("/api/post/{id}")
    public Optional<Post> readOnePost(@PathVariable Long id){
        return postRepository.findById(id);
    }
}



