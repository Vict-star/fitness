package com.software.fitness.controller;

import com.software.fitness.domain.*;
//import com.software.fitness.service.AdminService;
import com.software.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("/coachManage")
    public String coachManagePage(HttpServletRequest request, Model model) {
        List<Coach> coachList=adminService.coachPage();
        model.addAttribute("coachList",coachList);
        Staff staff = (Staff) request.getSession().getAttribute("loginUser");
        if (staff == null) {
            return "Login";
        } else {
            return "admin/coachManage";
        }
    }

    @GetMapping("/memberManage")
    public String memberManagePage(HttpServletRequest request) {
        Staff user = (Staff) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "Login";
        } else {
            return "admin/memberManage";
        }
    }

    @GetMapping("/attendance")
    public String attendancePage(HttpServletRequest request) {
        Staff user = (Staff) request.getSession().getAttribute("loginUser");
        if (user == null) {
            return "Login";
        } else {
            return "admin/attendance";
        }
    }

    @PostMapping("/coachManage/add")
    public String addCoach(Coach coach,RedirectAttributes attributes){
        coach.setState("在职");
        System.out.println(coach.toString());
        Integer id = adminService.addCoach(coach);
        String message = "";
        if(id!=null && id!=-1){
            message = "添加教练成功,ID为:"+id+"。";
        }else{
            message = "添加失败，请稍后再次尝试！";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/admin/coachManage";
    }

    @PostMapping("/coachManage/{id}/dismiss")
    public String dismissCoach(@PathVariable("id") Integer id,RedirectAttributes attributes){
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
    public String coachEditPage(@PathVariable int id, Model model) {
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

    @GetMapping("/classManage")
    public String classManagePage(){
        /*获取课程页（使用pagehelper分页）逻辑*/
        return "/admin/classManage";
    }

    @GetMapping("/classManage/{ID}")
    public String classEditPage(@PathVariable int ID){
        /*获取单课程逻辑*/
        return "/admin/classEdit";
    }

    @PostMapping("/courseManage/add")
    public String addCourse(Course course, RedirectAttributes attributes){
        /*添加课程逻辑*/
        /*添加提示逻辑*/
        return "redirect:/admin/classManage";
    }
}
