package com.blog.blogprac.domain;


import lombok.Getter;

@Getter
public class PostRequestDto {

    private String name;
    private String title;
    private String contents;
    private String url;
}
