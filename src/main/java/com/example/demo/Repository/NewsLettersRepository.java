package com.example.demo.Repository;

import com.example.demo.Model.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsLettersRepository extends JpaRepository<NewsLetter, Long> {

    List<NewsLetter> findAll();
}
