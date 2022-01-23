package com.reginabei.blog.dao;

import com.reginabei.blog.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageDao extends CrudRepository<Image, Long> {
}
