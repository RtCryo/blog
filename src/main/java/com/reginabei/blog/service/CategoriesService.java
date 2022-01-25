package com.reginabei.blog.service;

import com.reginabei.blog.dao.CategoriesDao;
import com.reginabei.blog.model.Category;
import com.reginabei.blog.model.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    private CategoriesDao categoriesDao;

    public List<Theme> getAllThemesByCategory(Category category) {
         return categoriesDao.findById(category.getId()).map(Category::getThemes).orElse(new ArrayList<>());
    }

    public List<Category> getAllCategories(){
        return (List<Category>) categoriesDao.findAll();
    }

    public void createCategory(Category category) {
        categoriesDao.save(category);
    }
}
