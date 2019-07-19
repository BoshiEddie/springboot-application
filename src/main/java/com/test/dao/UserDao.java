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

    public int setUserD(Integer id, String username, String tel){
        String sql = "update users set username = \"" + username + "\", tel=\"" + tel + "\" where id = ?";
        return baseDao.updateById(sql,id);
    }

    public User getUserById(Integer id){
        String sql = "select * from users where id = ?";
        return baseDao.queryById(sql,User.class,id);
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

        int flag = baseDao.deleteById("users",id);

        if(flag > 0){
            return 1;
        }else{
            return 0;
        }
    }

    public int insert(String name, String username, String password, String sex, String tel){

        if(sex.equals("Male")){
            sex="1";
        }else{
            sex="0";
        }
        User user = new User(null,name,username,password,sex,tel);
        String sql = "insert into users values(?,?,?,?,?,?)";

        int flag = baseDao.update2(sql,new Object[]{null,name,username,password,sex,tel});

        if(flag>=0){
            return 1;
        }else{
            return 0;
        }

    }
}

