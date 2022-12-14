package com.example.kc.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AppController {

    @GetMapping(value = "")
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/aboutUs")
    public String getAboutUsPage() {
        return "about-us";
    }

    @GetMapping(value = "/gallery")
    public String getGallery() {
        return "gallery";
    }
}
