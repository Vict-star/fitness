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
    public String classManagePage(HttpServletRequest request, Model model){
        List<Course> courseList=adminService.coursePage();
        model.addAttribute("courseList",courseList);
        Staff staff = (Staff) request.getSession().getAttribute("loginUser");
        if (staff == null) {
            return "Login";
        } else {
            return "admin/classManage";
        }
    }

    @GetMapping("/classManage/{ID}")
    public String classEditPage(@PathVariable int ID,Model model){
        Course course = adminService.getCourseById(ID);
        model.addAttribute("course",course);
        return "/admin/classEdit";
    }

    @PostMapping("/courseManage/add")
    public String addCourse(Course course, RedirectAttributes attributes){
        course.setNumber_of_member(0);//课程初始人数为0
        System.out.println(course.toString());
        Integer id = adminService.addCourse(course);
        String message = "";
        if(id!=null && id!=-1){
            message = "添加课程成功，课程ID为:"+id+"。";
        }else{
            message = "添加失败，请稍后再次尝试！";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/admin/classManage";
    }
    
    @PostMapping("/courseManage/{ID}/delete")
    public String deleteCourse(@PathVariable int ID, RedirectAttributes attributes) {
    	String message;
    	if(adminService.deleteCourse(ID))
    		message = "删除课程成功！";
    	else
    		message = "删除课程失败，请稍后再次尝试！";
    	attributes.addAttribute("message", message);
    	return "redirect:/admin/classManage";
    }
    
    @PostMapping("/courseManage/{ID}/update")
    public String updateCourse(@PathVariable int ID,Course course, RedirectAttributes attributes) {
    	String message;
    	course.setID(ID);
    	if(adminService.updateCourse(course))
    		message = "更新课程成功！";
    	else
    		message = "更新课程失败，请稍后再次尝试！";
    	attributes.addAttribute("message", message);
    	return "redirect:/admin/classManage";
    }

    
    
    
    @GetMapping("/chooseClass")
    public String chooseClassPage(HttpServletRequest request, Model model){
        List<Course> courseList=adminService.coursePage();
        model.addAttribute("courseList",courseList);
        Staff staff = (Staff) request.getSession().getAttribute("loginUser");
        if (staff == null) {
            return "Login";
        } else {
            return "admin/chooseClass";
        }
    }
    
    @PostMapping("/chooseClass/{ID}/check")
    public String checkOneTake(RedirectAttributes attributes,Model model,int ID){
    	List<Take_course> takes = adminService.getTakeByCourseid(ID);
    	model.addAttribute("take_courseList", takes);
    	return "admin/chooseClass";
    }

    @PostMapping("/chooseClass/add")
    public String takeClass(Take_course take_course,RedirectAttributes attributes){
    	String message;
    	Member member = adminService.getMemberById(take_course.getMember_id());
    	List<Take_course> takes = adminService.getTakeByMemberid(member.getID());
    	if(takes.size()==2) {
    		message="选课失败，该会员选课数已达上限！";
            attributes.addFlashAttribute("message", message);
            return "redirect:/admin/chooseClass";
    	}
    	//该会员选课数是否已达上限是否
    	for(int i = 0;i<takes.size();i++)
    		if(takes.get(i).getCourse_id()==take_course.getCourse_id()) {
        		message="选课失败，该会员已经选择了这门课程！";
                attributes.addFlashAttribute("message", message);
                return "redirect:/admin/chooseClass";
    		}
    	//该会员是否已选该课程
    	for(int i = 0;i<takes.size();i++) {
    		if(adminService.getCourseById(takes.get(i).getCourse_id()).getTime_slot_time_slot_id()==adminService.getCourseById(take_course.getCourse_id()).getTime_slot_time_slot_id()) {
        		message="选课失败，本次选课和该会员已选的课程有时间冲突！";
                attributes.addFlashAttribute("message", message);
                return "redirect:/admin/chooseClass";
    		}	
    	}
    	//本次选课是否和已选的课程有时间冲突
    	Course course = adminService.getCourseById(take_course.getCourse_id());
    	if(course.getNumber_of_member()==course.getCapacity()) {
    		message="选课失败，该课程人数已达上限！";
            attributes.addFlashAttribute("message", message);
            return "redirect:/admin/chooseClass";
		}
    	//该课程是否已满
        if(adminService.addTake(take_course)){
            message = "选课成功！";
        }else{
            message = "添加失败，请稍后再次尝试！";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/admin/chooseClass";
    }

    @PostMapping("/chooseClass/delete")
    public String dropClass(Take_course take_course,RedirectAttributes attributes) {
    	String message;
    	if(adminService.deleteTake(take_course))
    		message = "退课成功成功！";
    	else
    		message = "退课失败失败，请稍后再次尝试！";
    	attributes.addAttribute("message", message);
    	return "redirect:/admin/chooseClass";
    }
}
