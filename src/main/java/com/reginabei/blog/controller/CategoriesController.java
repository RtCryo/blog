package com.reginabei.blog.controller;

import com.reginabei.blog.model.Category;
import com.reginabei.blog.model.Theme;
import com.reginabei.blog.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoriesController {

    private CategoriesService categoriesService;

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<Category>> getListCategories(){
        return new ResponseEntity<>(categoriesService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/getAllThemesByCategory")
    public ResponseEntity<List<Theme>> getListThemesByCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoriesService.getAllThemesByCategory(category), HttpStatus.OK);
    }

}
