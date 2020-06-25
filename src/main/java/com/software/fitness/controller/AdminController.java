package com.software.fitness.controller;

import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Member;
import com.software.fitness.domain.User;
import com.software.fitness.domain.Staff;
//import com.software.fitness.service.AdminService;
import com.software.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("/coachManage")
    public String coachManagePage(HttpServletRequest request) {
        Staff staff = (Staff) request.getSession().getAttribute("loginUser");
        if (staff == null) {
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
    public String addCoach(Coach coach,RedirectAttributes attributes){
//        coach.setState("在职");
//        System.out.println(coach.toString());
//        Integer id = adminService.addCoach(coach);
        int id =2018306614;
        String message = "";
//        if(id!=null && id!=-1){
            message = "添加教练成功,ID为:"+id+"。";
//        }else{
//            message = "添加失败，请稍后再次尝试！";
//        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/admin/coachManage";
    }

    @GetMapping("/classTable")
    public String classTablePage(){
        return "/admin/classTable";
    }

    @PostMapping("/memberManage/add")
    public String addMember(Member member, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "添加结果");
        System.out.println(member.toString());
        return "redirect:/admin/memberManage";
    }
    @PostMapping("/coachManage/{id}/dismiss")
    public String dismissCoach(@PathVariable("id") Integer id, RedirectAttributes attributes){
        boolean result = adminService.dismissCoach(id);
        String message = "";
        if(result){
            message = "已离职"+id+"。";
        }else{
            message = "更改失败，请稍后重试！或联系管理员。";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/admin/coachManage";
    }

    @PostMapping("/coachManage/{id}/employ")
    public String employCoach(@PathVariable("id") Integer id,RedirectAttributes attributes){
        boolean result = adminService.employCoach(id);
        String message = "";
        if(result){
            message = "已启用"+id+"。";
        }else{
            message = "更改失败，请稍后重试！或联系管理员。";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/admin/coachManage";
    }

    @GetMapping("/classTable")
    public String classTablePage(){
        return "/admin/classTable";
    }

    @PostMapping("/memberManage/add")
    public String addMember(Member member, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", "添加结果");
        System.out.println(member.toString());
        return "redirect:/admin/memberManage";
    }

    @GetMapping("/coachManage/{id}")
    public String coachInfoModal(@PathVariable int id, Model model) {
        Coach coach = adminService.getCoach(id);
        model.addAttribute("coach",coach);
        return "/admin/coachEdit";
    }

    @PostMapping("/coachManage/{id}/update")
    public String updateCoach(@PathVariable int id, Coach coach,RedirectAttributes attributes) {
        boolean result = adminService.updateCoach(coach);
        String message;
        if(result){
            message = "更新成功";
        }else{
            message = "更改失败，请稍后重试！或联系管理员。";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/admin/coachManage/"+id;
    }

}
