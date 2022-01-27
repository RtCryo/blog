package com.reginabei.blog.service;

import com.reginabei.blog.dao.CategoriesDao;
import com.reginabei.blog.model.Category;
import com.reginabei.blog.model.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    private final CategoriesDao categoriesDao;

    public List<Theme> getAllThemesByCategory(String category) {
        return categoriesDao.findByName(category).getThemes();
    }

    public List<Category> getAllCategories(){
        return (List<Category>) categoriesDao.findAll();
    }

    public void createCategory(Category category) {
        categoriesDao.save(category);
    }

    public void deleteCategories(List<Category> categories) {
        categoriesDao.deleteAll(categories);
    }
}
