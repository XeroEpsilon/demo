package com.example.demo.Web;

import com.example.demo.Model.CategoriesSearchRequest;
import com.example.demo.Model.CategoriesSearchResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CategoryWeb {

    @GetMapping("/categories")
    public CategoriesSearchResponse getCategories(@RequestBody CategoriesSearchRequest categoriesSearchRequest);

    @PostMapping("/categories")
    public com.example.demo.Model.Category createCategories(@RequestBody com.example.demo.Model.Category category);
}
