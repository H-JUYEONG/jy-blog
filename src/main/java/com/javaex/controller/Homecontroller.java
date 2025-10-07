package com.javaex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Homecontroller {
    @GetMapping("/")
    public String home() {
        return "jy-blog 프로젝트가 시작되었습니다.";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, MyBatis + JPA Blog.";
    }

    @GetMapping("/api")
    public String api() {
        return "API 서버가 정상 작동중입니다.";
    }
}
