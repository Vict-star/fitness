package com.software.fitness.controller;


import com.software.fitness.domain.Record;
import com.software.fitness.domain.Staff;
import com.software.fitness.service.AdminService;
import com.software.fitness.service.RecordService;
import com.software.fitness.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    StaffService staffService;
    @Autowired
    RecordService recordService;

    @GetMapping("/staffManage")
    public String staffManagePage(HttpServletRequest request,
                                  Model model) {
        if (isAdmin(request)) {
            List<Staff> list = adminService.PageStaff();
            model.addAttribute("staffList", list);
            return "staff/staffManage";
        } else {
            return "redirect:/index";
        }
    }

    @GetMapping("/staffManage/{id}")
    public String staffEditPage(@PathVariable("id") int id, HttpServletRequest request,
                                Model model) {
        if (isAdmin(request)) {

            model.addAttribute("staff", adminService.getStaffByID(id));
            return "staff/staffEdit";
        } else {
            return "redirect:/index";
        }
    }

    private boolean isAdmin(@NonNull HttpServletRequest request) {
        Staff staff = (Staff) request.getSession().getAttribute("loginUser");
        return staff.getIs_admin().equals("是");
    }

    private Record genRecord(int id, String op) {
        Record record = new Record();
        record.setStaff_id(id);
        record.setOperation(op);
        return record;
    }

    @PostMapping("/staffManage/{id}/cancel")
    public String staffCancelPage(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        Staff staff = new Staff();
        staff.setId(id);
        staff.setState("离职");
        int er = staffService.updateStaff(staff);
        if (er > 0) {
            message = "员工已离职";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "离职员工：" + staff.toString()));
        } else {
            message = "更新员工失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(staff.toString());
        return "redirect:/staff/staffManage";
    }

    @PostMapping("/staffManage/{id}/activate")
    public String staffActivatePage(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        Staff staff = new Staff();
        staff.setId(id);
        staff.setState("在职");
        int er = staffService.updateStaff(staff);
        if (er > 0) {
            message = "员工已在职";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "在职员工：" + staff.toString()));
        } else {
            message = "更新员工失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(staff.toString());
        return "redirect:/staff/staffManage";
    }

    @PostMapping("/staffManage/{id}/update")
    public String staffActivatePage(@PathVariable("id") int id, Staff staff, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        staff.setId(id);
        int er = staffService.updateStaff(staff);
        if (er > 0) {
            message = "更新员工成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "在职员工：" + staff.toString()));
        } else {
            message = "更新员工失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(staff.toString());
        return "redirect:/staff/staffManage";
    }
}
