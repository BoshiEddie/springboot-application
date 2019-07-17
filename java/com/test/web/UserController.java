package com.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
;
import com.test.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
//@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/index", method = {RequestMethod.POST,RequestMethod.GET})
    public String index(){
        return "login";
    }


    @RequestMapping(value="/login", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(@RequestParam("username") String loginname, @RequestParam("password") String loginpwd, Model model){
        int flag = userService.login(loginname,loginpwd);
        if(flag>0) {
            return "index";
        }else{
            model.addAttribute("error","您输入的用户名和密码错误");
            return "login";
        }
    }


}
