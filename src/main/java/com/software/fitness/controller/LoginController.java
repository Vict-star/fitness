package com.software.fitness.controller;

import com.software.fitness.domain.Staff;
import com.software.fitness.service.StaffService;
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
    private StaffService staffService;

    @GetMapping
    public String login(HttpServletRequest request) {
        Staff user = (Staff) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "Login";
        } else {
            return "staff/index";
        }
    }

    @PostMapping("/Login")
    public String login(@RequestParam String phone_number, @RequestParam String password,
                            RedirectAttributes attributes, HttpServletRequest request) {
        Staff staff = staffService.getStaffByPhoneNumber(phone_number);
        System.out.print(staff);
        if (staff != null && staff.getPassword().equals(password) && staff.getState().equals("在职")) {
            staff.setPassword("");
            request.getSession().setAttribute("loginUser", staff);
            return "/staff/index";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/index";
        }
    }

    @GetMapping("/Logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginUser");
        return "redirect:/index";
    }
}
