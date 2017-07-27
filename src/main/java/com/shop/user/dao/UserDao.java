package com.shop.user.dao;

import com.shop.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Mingyu Lee on 2017-07-15.
 * Description:
 */
public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();

}
