package com.sparta.projectprac.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String job;

    @Column (nullable = false)
    private int age;

    @Column (nullable = false)
    private String address;

    public Person(PersonRequestDto personRequestDto) {
        this.name = personRequestDto.getName();
        this.job = personRequestDto.getJob();
        this.age = personRequestDto.getAge();
        this.address = personRequestDto.getAddress();
    }

    public Person(String name, String job, int age, String address) {
        this.name = name;
        this.job = job;
        this.age = age;
        this.address = address;
    }

}