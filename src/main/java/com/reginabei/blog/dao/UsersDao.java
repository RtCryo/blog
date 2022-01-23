package com.reginabei.blog.dao;

import com.reginabei.blog.model.BlogUser;
import org.springframework.data.repository.CrudRepository;

public interface UsersDao extends CrudRepository<BlogUser, Long> {

    BlogUser findByName(String name);

}
