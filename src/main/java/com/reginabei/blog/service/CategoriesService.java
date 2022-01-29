package com.reginabei.blog.service;

import com.reginabei.blog.dao.CategoriesDao;
import com.reginabei.blog.dao.CategoryThemesRelationshipDao;
import com.reginabei.blog.dto.CategoryDto;
import com.reginabei.blog.model.Category;
import com.reginabei.blog.model.CategoryThemesRelationship;
import com.reginabei.blog.model.Theme;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesService {

    private final CategoriesDao categoriesDao;
    private final CategoryThemesRelationshipDao categoryThemesRelationshipDao;

    public List<Theme> getAllThemesByCategory(String category) {
        List<Theme> themes = new ArrayList<>();
        categoryThemesRelationshipDao.findAllByCategory(categoriesDao.findByNameOrderByName(category)).forEach(e ->
                themes.add(e.getTheme()));
        return themes;
    }

    public List<Category> getAllCategories(){
        return (List<Category>) categoriesDao.findAll(Sort.by("name"));
    }

    public void saveOrUpdateCategory(CategoryDto categoryDto) {
        Category newCategory = categoriesDao.findById(categoryDto.getId()).map(category -> {
            categoryThemesRelationshipDao.deleteAllByCategory(category);
            return category;
        }).orElse(categoriesDao.save(dtoToModel(categoryDto)));
        saveNewRelationship(categoryDto.getThemes(),newCategory);
    }

    private void saveNewRelationship(List<Theme> themes, Category category){
        themes.forEach(e -> {
            CategoryThemesRelationship categoryThemesRelationship = new CategoryThemesRelationship();
            categoryThemesRelationship.setTheme(e);
            categoryThemesRelationship.setCategory(category);
            categoryThemesRelationshipDao.save(categoryThemesRelationship);
        });
    }

    public void deleteCategories(List<CategoryDto> categoriesDto) {
        categoriesDto.forEach(e ->{
            Category categoryToDelete = dtoToModel(e);
            categoryThemesRelationshipDao.deleteAll(categoryThemesRelationshipDao.findAllByCategory(categoryToDelete));
            categoriesDao.delete(categoryToDelete);
        });

    }

    private Category dtoToModel(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }
}
