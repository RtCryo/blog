package com.reginabei.blog.dao;

import com.reginabei.blog.model.BlogUser;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<BlogUser, Long> {

    BlogUser findByName(String name);

}
