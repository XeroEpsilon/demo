package com.example.demo.Web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface NewsLetter {

    @PostMapping("/newsletters/")
    public com.example.demo.Model.NewsLetter createNewsLetter(@RequestBody com.example.demo.Model.NewsLetter newsLetter);

    @GetMapping("/newsletters/")
    public List<com.example.demo.Model.NewsLetter> getAllNewsLetter(@RequestBody com.example.demo.Model.NewsLetter newsLetter);

}
