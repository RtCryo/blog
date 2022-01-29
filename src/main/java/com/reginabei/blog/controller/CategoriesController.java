package com.reginabei.blog.controller;

import com.reginabei.blog.dto.CategoryDto;
import com.reginabei.blog.model.Category;
import com.reginabei.blog.model.Theme;
import com.reginabei.blog.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoriesController {

    private final CategoriesService categoriesService;

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<Category>> getListCategories(){
        return new ResponseEntity<>(categoriesService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/getAllThemesByCategory")
    public ResponseEntity<List<Theme>> getListThemesByCategory(@RequestParam String categoryName) {
        return new ResponseEntity<>(categoriesService.getAllThemesByCategory(categoryName), HttpStatus.OK);
    }

    @PostMapping("/createCategory")
    public ResponseEntity<HttpStatus> createCategory(@RequestBody CategoryDto categoryDto) {
        categoriesService.saveOrUpdateCategory(categoryDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deleteCategories")
    public ResponseEntity<HttpStatus> deleteCategories(@RequestBody List<CategoryDto> categoriesDto) {
        categoriesService.deleteCategories(categoriesDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
