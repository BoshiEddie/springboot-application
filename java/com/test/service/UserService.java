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

}