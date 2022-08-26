package com.example.demo.Service;

import com.example.demo.Model.CategoriesSearchRequest;
import com.example.demo.Model.CategoriesSearchResponse;
import com.example.demo.Model.Category;
import com.example.demo.Model.NewsLetter;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Web.CategoryWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CategoryService implements CategoryWeb {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoriesSearchResponse getCategories(@RequestBody CategoriesSearchRequest categoriesSearchRequest) {
        CategoriesSearchResponse categoriesSearchResponse = new CategoriesSearchResponse();
        categoriesSearchResponse.setNewsLetters(new ArrayList<>());
        for (String category: categoriesSearchRequest.getCategories()) {
            //TODO: rename
            Optional<Category> categoryDB = categoryRepository.findByCategory(category);
            if (categoryDB.isPresent() && categoryDB.get().getNewsLetters() != null) {
                categoriesSearchResponse.getNewsLetters().add(Map.of(category, categoryDB.get().getNewsLetters()));
            } else {
                categoriesSearchResponse.getNewsLetters().add(Map.of(category, Collections.<NewsLetter>emptySet()));
            }
        }
        return categoriesSearchResponse;
    }

    public Category createCategories(@RequestBody Category category) {
        // TODO: HANDLE FAILURE
        categoryRepository.save(category);
        // TODO: Response body http code
        return category;
    }

}
