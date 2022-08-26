package com.example.demo.Model;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class CategoriesSearchResponse {
    public List<Map<String, Set<NewsLetter>>> newsLetters;
}
