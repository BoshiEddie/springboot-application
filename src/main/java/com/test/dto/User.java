package com.test.dto;



import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
@Data
public class User extends BaseDTO{
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String sex;
    private String tel;

    public User(Integer id, String name, String username, String password, String sex, String tel) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
