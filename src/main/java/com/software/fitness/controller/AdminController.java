package com.software.fitness.controller;

import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Member;
import com.software.fitness.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/coachManage")
    public String coachManagePage(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "Login";
        } else {
            return "admin/coachManage";
        }
    }

    @GetMapping("/memberManage")
    public String memberManagePage(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "Login";
        } else {
            return "admin/memberManage";
        }
    }

    @GetMapping("/attendance")
    public String attendancePage(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "Login";
        } else {
            return "admin/attendance";
        }
    }

    @PostMapping("/coachManage/add")
    public String addCoach(Coach coach, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "添加结果");
        System.out.println(coach.toString());
        return "redirect:/admin/coachManage";
    }

    @PostMapping("/memberManage/add")
    public String addMember(Member member, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "添加结果");
        System.out.println(member.toString());
        return "redirect:/admin/memberManage";
    }


}
