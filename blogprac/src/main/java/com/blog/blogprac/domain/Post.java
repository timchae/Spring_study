package com.blog.blogprac.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends TimeStamped{


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    private String url;

    public Post(PostRequestDto requestDto){
        this.name = requestDto.getName();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.url = requestDto.getUrl();
    }

    public void update(PostRequestDto requestDto){
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.url = requestDto.getUrl();

    }
    /*필요 기능
    1. 제목, 작성자명, 작성 날자 조회
    2. 작성날짜 내림차순
    3.
     */
}
