package com.reginabei.blog.service;

import com.reginabei.blog.dao.UsersDao;
import com.reginabei.blog.model.BlogUser;
import com.reginabei.blog.model.SecurityUserModel;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("myUserDetailsService")
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService{

    private final UsersDao usersDao;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            BlogUser user = usersDao.findByName(s);
            return SecurityUserModel.fromUser(user);
        } catch (Exception ex) {
            throw new UsernameNotFoundException("User doesn't exists");
        }
    }

}
