package com.reginabei.blog.dao;

import com.reginabei.blog.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoriesDao extends CrudRepository<Category, Long> {
}
