package com.sparta.week2.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor

public class CourseRequestDto {
    private final String title;
    private final String tutor;
}
