package com.software.fitness.controller;


import com.github.pagehelper.PageInfo;
import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Staff;
import com.software.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/staffManage")
    public String coachManagePage(HttpServletRequest request,
                                  Model model) {
        if (isAdmin(request)) {
            List<Staff> list =adminService.PageStaff();
            model.addAttribute("staffList", list);
            return "staff/staffManage";
        }else{
            return "redirect:/index";
        }
    }

    private boolean isAdmin(@NonNull HttpServletRequest request) {
        Staff staff = (Staff) request.getSession().getAttribute("loginUser");
        return staff.getIs_admin().equals("是");
    }


}
