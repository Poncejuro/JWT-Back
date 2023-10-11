package com.example.demo.Security;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/example")
@RequiredArgsConstructor
public class ControllerExample {

    @PostMapping(value = "example")
    public String welcome(){
        return "welcome to security endpoint";
    }

}
