package com.reginabei.blog.dao;

import com.reginabei.blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriesDao extends PagingAndSortingRepository<Category, Long> {

    Category findByNameOrderByName(String name);

}
