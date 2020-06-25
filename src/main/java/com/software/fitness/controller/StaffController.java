package com.software.fitness.controller;

import com.software.fitness.domain.*;
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

@Controller
@RequestMapping("/staff")
public class StaffController {
    /**
     * TODO 主页 /index
     * TODO 教练管理 /coachManage /add添加 /edit修改
     * TODO 会员管理 /memberManage /add添加 /edit修改
     * TODO 签到 /attendance /sign签到
     * TODO 课程管理 /courseManage /add添加 /edit修改
     * TODO 会员选课 /chooseClass /pick选课 /quit退课
     * TODO 课程表 /classTable
     * TODO 操作员管理 /staffManage /add添加 /edit修改
     * TODO 历史记录 /history
     */

    @Autowired
    private StaffService staffService;

    /**
     * @param request
     * @return 是否登陆成功
     */
    private boolean isLogin(@NonNull HttpServletRequest request) {
        Staff staff = (Staff) request.getSession().getAttribute("loginUser");
        return staff != null;
    }

    /**
     * @param request
     * @return 是否为管理员
     */
    private boolean isAdmin(@NonNull HttpServletRequest request) {
        Staff staff = (Staff) request.getSession().getAttribute("loginUser");
        return staff.getIs_admin().equals("是");
    }


    /**
     * 以下是GET方法的函数
     */
    @GetMapping("/coachManage")
    public String coachManagePage(HttpServletRequest request, Model model) {
        if(isLogin(request)){
            model.addAttribute("coachList",staffService.getAllCoach());
            return "staff/coachManage";
        }
        return "Login";
    }

    @GetMapping("/memberManage")
    public String memberManagePage(HttpServletRequest request, Model model) {
        if(isLogin(request)){
            model.addAttribute("memberList",staffService.getAllMember());
            return "staff/memberManage";
        }
        return "Login";
    }

    @GetMapping("/attendance")
    public String attendancePage(HttpServletRequest request) {
        return isLogin(request) ? "staff/attendance" : "Login";
    }

    @GetMapping("/classTable")
    public String classTablePage(HttpServletRequest request) {
        return isLogin(request) ? "staff/classTable" : "Login";
    }

    @GetMapping("/chooseClass")
    public String chooseClassPage(HttpServletRequest request) {
        return isLogin(request) ? "staff/chooseClass" : "Login";
    }

    @GetMapping("/courseManage")
    public String courseManagePage(HttpServletRequest request) {
        return isLogin(request) ? "staff/courseManage" : "Login";
    }

    //更高权限
    @GetMapping("/staffManage")
    public String staffManagePage(HttpServletRequest request) {
        return isLogin(request) && isAdmin(request) ? "staff/staffManage" : "Login";
    }

    @GetMapping("/history")
    public String historyPage(HttpServletRequest request) {
        return isLogin(request) && isAdmin(request) ? "staff/history" : "Login";
    }

    @GetMapping("/coachManage/{id}")
    public String coachEditPage(@PathVariable("id") int id, HttpServletRequest request, Model model) {
        if(isLogin(request)){
            model.addAttribute("coach",staffService.getCoachByID(id));
            return "staff/coachEdit";
        }
        Coach coach = staffService.getCoachByID(id);
        model.addAttribute("coach",coach);
        return "Login";
    }

    /**
     * 以下是POST方法的函数
     */

    //TODO coachManage页面操作方法
    @PostMapping("/coachManage/add")
    public String addCoach(Coach coach, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.insertCoach(coach);
        if (id > 0) {
            message = "添加教练成功";
        } else {
            message = "添加教练失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(coach.toString());
        return "redirect:/staff/coachManage";
    }

    @PostMapping("/coachManage/edit")
    public String editCoach(Coach coach, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.updateCoach(coach);
        if (id > 0) {
            message = "修改教练成功";
        } else {
            message = "修改教练失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(coach.toString());
        return "redirect:/staff/coachManage";
    }

    @PostMapping("/coachManage/{id}/dismiss")
    public String dismissCoach(@PathVariable("id") Integer id, RedirectAttributes attributes){
        Coach coach = new Coach();
        coach.setId(id);
        coach.setState("离职");
        Integer er = staffService.updateCoach(coach);
        String message = "";
        if(er != null && er > 0){
            message = "" + id + " 已离职";
        }else{
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage";
    }

    @PostMapping("/coachManage/{id}/employ")
    public String employCoach(@PathVariable("id") Integer id,RedirectAttributes attributes){
        Coach coach = new Coach();
        coach.setId(id);
        coach.setState("在职");
        Integer er = staffService.updateCoach(coach);
        String message = "";
        if(er != null && er > 0){
            message = "" + id + " 已启用";
        }else{
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage";
    }

    @PostMapping("/coachManage/{id}/update")
    public String updateCoach(@PathVariable int id, Coach coach,RedirectAttributes attributes) {
        coach.setId(id);
        Integer er = staffService.updateCoach(coach);
        String message;
        if(er != null && er > 0){
            message = "更新成功";
        }else{
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage/"+id;
    }



    //TODO memberManage页面操作方法
    @PostMapping("/memberManage/add")
    public String addMember(Member member, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.insertMember(member);
        if (id > 0) {
            message = "添加会员成功";
        } else {
            message = "添加会员失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(member.toString());
        return "redirect:/staff/memberManage";
    }

    @PostMapping("/memberManage/edit")
    public String editMember(Member member, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.updateMember(member);
        if (id > 0) {
            message = "修改会员成功";
        } else {
            message = "修改会员失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(member.toString());
        return "redirect:/staff/memberManage";
    }

    //TODO attendance页面操作方法
    @PostMapping("/attendance/sign")
    public String attendanceSign(Attendance attendance, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.insertAttendance(attendance);
        if (id > 0) {
            message = "签到成功";
        } else {
            message = "签到失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(attendance.toString());
        return "redirect:/staff/attendance";
    }

    //TODO courseManage页面操作方法
    @PostMapping("/courseManage/add")
    public String addCourse(Course course, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.insertCourse(course);
        if (id > 0) {
            message = "添加课程成功";
        } else {
            message = "添加课程失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(course.toString());
        return "redirect:/staff/courseManage";
    }

    @PostMapping("/courseManage/edit")
    public String editCourse(Course course, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.updateCourse(course);
        if (id > 0) {
            message = "修改课程成功";
        } else {
            message = "修改课程失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(course.toString());
        return "redirect:/staff/courseManage";
    }

    //TODO chooseClass页面操作方法
    @PostMapping("/chooseClass/pick")
    public String pickClass(Take_course take_course, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.insertTakeCourse(take_course);
        if (id > 0) {
            message = "选课成功";
            //同步已选课程数和课程的会员数
            staffService.increaseNumberOfMember(take_course.getCourse_id());
            staffService.increaseNumberOfCourses(take_course.getMember_id());
        } else {
            message = "选课失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(take_course.toString());
        return "redirect:/staff/chooseClass";
    }

    @PostMapping("/chooseClass/quit")
    public String quitClass(Take_course take_course, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.deleteTakeCourse(take_course);
        if (id > 0) {
            message = "退课成功";
            //同步已选课程数和课程的会员数
            staffService.decreaseNumberOfMember(take_course.getCourse_id());
            staffService.decreaseNumberOfCourses(take_course.getMember_id());
        } else {
            message = "退课失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(take_course.toString());
        return "redirect:/staff/chooseClass";
    }

    //TODO staffManage页面操作方法S
    @PostMapping("/staffManage/add")
    public String addStaff(Staff staff, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.insertStaff(staff);
        if (id > 0) {
            message = "添加员工成功";
        } else {
            message = "添加员工失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(staff.toString());
        return "redirect:/staff/staffManage";
    }

    @PostMapping("/staffManage/edit")
    public String editStaff(Course staff, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.updateCourse(staff);
        if (id > 0) {
            message = "修改员工成功";
        } else {
            message = "修改员工失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(staff.toString());
        return "redirect:/staff/staffManage";
    }
}
