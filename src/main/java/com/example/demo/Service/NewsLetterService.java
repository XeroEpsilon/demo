package com.example.demo.Service;

import com.example.demo.Model.NewsLetter;
import com.example.demo.Repository.NewsLettersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsLetterService extends NewsLetter {

    @Autowired
    NewsLettersRepository newsLettersRepository;

    @PostMapping("/newsletters/")
    public NewsLetter createNewsLetter(@RequestBody NewsLetter newsLetter) {
        // TODO: HANDLE FAILURE
        newsLettersRepository.save(newsLetter);
        // TODO: Response body http code
        return newsLetter;
    }

    @GetMapping("/newsletters/")
    public List<NewsLetter> getAllNewsLetter(@RequestBody NewsLetter newsLetter) {
        return newsLettersRepository.findAll();
    }

}
