package com.software.fitness.controller;

import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Staff;
//import com.software.fitness.service.AdminService;
import com.software.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
