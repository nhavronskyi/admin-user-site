package com.example.adminusersite.dao;

import com.example.adminusersite.user.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findUser(String uname, String upass);

    void createUser(String uname, String upass);

    void deleteUser(int id);

    void updateUser(String uname, String upass, int id);
}
