package com.test.dao;

import com.test.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao{
    @Autowired
    BaseDao baseDao;


    public List<User> getUserList(String name){
        String sql = "select * from users where name like ?";
        return baseDao.query(sql,User.class,new Object[]{"%"+name+"%"});
    }


    public int login(String loginname,String loginpwd){
        String sql = "select * from users where username=? and password=?";
        List<User> users =  baseDao.query(sql,User.class,new Object[]{loginname,loginpwd});

        if(users!=null && users.size()>0){
            return 1;
        }else{
            return 0;
        }
    }

    public List<User> getAllUser() {
        String sql = "select * from users";
        List<User> users = baseDao.query(sql, User.class);

        return users;

    }

    public int delete(int id){
        String sql = "delete from users where id=?";
        int flag = baseDao.delete(sql,id);

        if(flag > 0){
            return 1;
        }else{
            return 0;
        }
    }

//    public int insert(String name, String username, String password, String sex, String tel){
//        String sql = "insert into users values(null,?,?,?,?,?)";
//        int flag = baseDao.insert();
//
//        if(flag > 0){
//            return 1;
//        }else{
//            return 0;
//        }
//
//    }
}

