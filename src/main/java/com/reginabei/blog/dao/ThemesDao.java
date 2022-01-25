package com.reginabei.blog.dao;

import com.reginabei.blog.model.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemesDao extends CrudRepository<Theme, Long> {
}
