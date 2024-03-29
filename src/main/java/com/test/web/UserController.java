package com.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.test.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
;
import com.test.service.UserService;

import java.util.List;


@Controller

public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping(value={"/","/index"}, method = {RequestMethod.POST,RequestMethod.GET})
    public String index(){
        return "login";
    }

    @RequestMapping(value="/login", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(@RequestParam("username") String loginname, @RequestParam("password") String loginpwd, Model model){
        int flag = userService.login(loginname,loginpwd);
        if(flag>0) {
            return "index";
        }else{
            model.addAttribute("error","Your passwrod or username do not correct");
            return "login";
        }
    }

    @ModelAttribute
    @RequestMapping(value = "/dashboard")
    public String dashBoard(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("data",users);
        return "dashboard";
    }

    @RequestMapping(value="/delete",method = RequestMethod.GET)
    public String delete(@RequestParam("id") Integer id, Model model){
        int flag = userService.delete(id);
        if(flag > 0){
            model.addAttribute("msg","Delete Successful");
        }else{
            model.addAttribute("msg","Oops, something was wrong");
        }
        return "delete";
    }

    @RequestMapping(value = "/insert",method = {RequestMethod.POST,RequestMethod.GET})
    public String insert(){
        return "insert";
    }

    @RequestMapping(value="/doInsert" ,method = {RequestMethod.POST,RequestMethod.GET})
    public String insert1(
            @RequestParam("name") String name,@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("sex") String sex, @RequestParam("tel") String tel
    ,Model model){

        int flag = userService.insert(name,username,password,sex,tel);
        if(flag > 0){
            model.addAttribute("msg","Insert Successful");
        }else{
            model.addAttribute("msg","Oops, something was wrong");
        }

        return "doInsert";
    }

    @RequestMapping(value="/edit",method = {RequestMethod.POST,RequestMethod.GET})
    public String edit(@RequestParam Integer id,Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "edit";
    }

    @RequestMapping(value = "/doEdit" ,method={RequestMethod.POST,RequestMethod.GET})
    public String edit1(@RequestParam Integer id, @RequestParam String username, @RequestParam String tel , Model model){
        int flag = userService.update(id,username,tel);
        if(flag >= 0){
            model.addAttribute("msg","Update Successful");
        }else{
            model.addAttribute("msg","Oops! Something wrong");
        }
        return "doEdit";
    }

}
