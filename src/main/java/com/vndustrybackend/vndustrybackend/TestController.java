package com.vndustrybackend.vndustrybackend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TestController {
    @GetMapping("/")
    public String home() {
        return "Hello world";
    }

}
