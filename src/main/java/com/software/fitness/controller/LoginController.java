package com.software.fitness.controller;

import com.software.fitness.domain.User;
import com.software.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/index")
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String login(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if(user == null){
            return "Login";
        }
        else{
            return "admin/index";
        }
    }

    @PostMapping("/Login")
    public String userlogin(@RequestParam String userId, @RequestParam String password,
                            RedirectAttributes attributes, HttpServletRequest request){
        User user = userService.getUserById(userId);
        System.out.print(user);
        if(user!=null&&user.getPassword().equals(password)){
            user.setPassword("");
            request.getSession().setAttribute("loginUser",user);
            return "/admin/index";
        }else{
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/index";
        }
    }

    @GetMapping("/Logout")
    public String userloginOut(HttpServletRequest request){
        request.getSession().removeAttribute("loginUser");
        return "redirect:/index";
    }
}
