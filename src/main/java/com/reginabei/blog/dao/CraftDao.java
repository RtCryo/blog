package com.reginabei.blog.dao;

import com.reginabei.blog.model.Category;
import com.reginabei.blog.model.Craft;
import com.reginabei.blog.model.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CraftDao extends CrudRepository<Craft, Long> {

    List<Craft> findCraftsByCategoryAndTheme(Category category, Theme theme);

}
