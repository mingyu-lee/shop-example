package com.shop.user.service;

import com.shop.user.domain.User;
import com.shop.user.domain.security.UserRole;

import java.util.List;
import java.util.Set;

/**
 * Created by Mingyu Lee on 2017-07-15.
 * Description:
 */
public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    void updateUser(User user);

    User createUser(User user, Set<UserRole> userRoles);

    List<User> findUserList();


}
