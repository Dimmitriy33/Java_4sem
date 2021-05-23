package com.shalunov.lab9.login.dao;

import com.shalunov.lab9.login.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User read(String username);

    boolean delete(String username);

    boolean create(User user);

    boolean update(User user);
}
