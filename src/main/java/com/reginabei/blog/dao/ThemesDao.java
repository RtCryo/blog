package com.reginabei.blog.dao;

import com.reginabei.blog.model.Theme;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ThemesDao extends CrudRepository<Theme, Long> {

    @Query(value = "SELECT DISTINCT name FROM theme ORDER BY name", nativeQuery = true)
    List<String> findAllDistinct();


}
