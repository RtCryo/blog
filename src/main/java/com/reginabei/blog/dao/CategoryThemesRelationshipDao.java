package com.reginabei.blog.dao;

import com.reginabei.blog.model.Category;
import com.reginabei.blog.model.CategoryThemesRelationship;
import com.reginabei.blog.model.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryThemesRelationshipDao extends CrudRepository<CategoryThemesRelationship, Long> {

    List<CategoryThemesRelationship> findAllByCategory(Category category);

    List<CategoryThemesRelationship> findAllByTheme(Theme theme);

    void deleteAllByCategory(Category category);

}
