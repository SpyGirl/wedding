package com.wedding.dao;

import com.wedding.entity.Role;
import com.wedding.entity.User;

import java.util.List;

public interface UserDao {

    User findByLogin(String login);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByFullName(String firstName, String lastName);
    List<User> findByGender(Character gender);
    User findByEmail(String email);
    List<User> findByRole(Role role);
}
