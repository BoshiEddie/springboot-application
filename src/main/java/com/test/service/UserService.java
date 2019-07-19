package com.test.service;

import com.test.dto.User;
import com.test.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int login(String username, String password){
        return userDao.login(username,password);
    }

    public List<User> getAllUsers(){ return userDao.getAllUser(); }

    public int delete(Integer id){ return  userDao.delete(id); }

    public int insert(String name, String username, String password, String sex, String tel) {return userDao.insert(name,username,password,sex,tel);}
}