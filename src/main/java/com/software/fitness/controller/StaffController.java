package com.software.fitness.controller;

import com.github.pagehelper.PageInfo;
import com.software.fitness.domain.*;
import com.software.fitness.service.RecordService;
import com.software.fitness.service.StaffService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private RecordService recordService;

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
    public String coachManagePage(HttpServletRequest request,
                                  @RequestParam(defaultValue = "1")int page,
                                  @RequestParam(defaultValue = "1")int pageSize,
                                  Model model) {
        System.out.println("page"+page+"Pagesize"+pageSize);

        if (isLogin(request)) {
            PageInfo<Coach> Page =staffService.PageAllCoach(page,pageSize);
            System.out.println(Page);
            model.addAttribute("coachPage", Page);
            return "staff/coachManage";
        }
        return "Login";
    }

    @GetMapping("/passwordManage")
    public String passwordManage(){
        return "staff/passwordManage";
    }

    @PostMapping("/passwordManage/update")
    public String passwordChange(RedirectAttributes attributes,
                                String phone_number,
                                 String staff_id,String old_pwd, String new_pwd){
        String message = "";
        boolean result = staffService.changePassword(phone_number,staff_id,old_pwd,new_pwd);
        if(result){
            message = "修改成功";
        }
        else{
            message = "修改失败，请联系管理员";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/passwordManage";
    }

    @GetMapping("/memberManage")
    public String memberManagePage(HttpServletRequest request, Model model) {
        model.addAttribute("memberList", staffService.getAllMember());
        return "staff/memberManage";
    }

    @GetMapping("/memberManage/{id}")
    public String memberEditPage(@PathVariable("id") int id, HttpServletRequest request, Model model) {
        model.addAttribute("member", staffService.getMemberByID(id));
        return "staff/memberEdit";
    }

    @GetMapping("/attendance")
    public String attendancePage(HttpServletRequest request, Model model) {
        model.addAttribute("courseList", staffService.getCourseByState("正在上课"));
        return "staff/attendance";
    }

    @GetMapping("/attendance/{id}")
    public String attendanceSignPage(@PathVariable("id") int id, HttpServletRequest request, Model model) {
        model.addAttribute("course", staffService.getCourseByID(id));
        model.addAttribute("memberList", staffService.getMemberByCourseID(id));
        return "staff/attendanceSign";
    }

    @GetMapping("/classTable")
    public String classTablePage(HttpServletRequest request, Model model) {
        List<CourseTableItem> list = staffService.listCourseTableItem();
        model.addAttribute("CourseTableItemList", list);
        return "staff/classTable";
    }

    @GetMapping("/chooseClass")
    public String chooseClassPage(HttpServletRequest request, Model model) {
        model.addAttribute("courseList", staffService.getAllCourse());
        return "staff/chooseClass";
    }

    @GetMapping("/courseManage")
    public String courseManagePage(HttpServletRequest request, Model model) {
        model.addAttribute("courseList", staffService.getAllCourse());
        return "staff/courseManage";
    }

    @GetMapping("/courseManage/{id}")
    public String courseEditPage(@PathVariable("id") int id, HttpServletRequest request, Model model) {
        model.addAttribute("course", staffService.getCourseByID(id));
        return "staff/courseEdit";
    }

    //更高权限
    @GetMapping("/staffManage")
    public String staffManagePage(HttpServletRequest request, Model model) {
        model.addAttribute("staffList", staffService.getAllStaff());
        return "staff/staffManage";
    }

    @GetMapping("/history")
    public String historyPage(HttpServletRequest request, Model model) {
        model.addAttribute("recordList", recordService.getAllRecord());
        return "staff/history";
    }

    @GetMapping("/coachManage/{id}")
    public String coachEditPage(@PathVariable("id") int id, HttpServletRequest request, Model model) {
        model.addAttribute("coach", staffService.getCoachByID(id));
        return "staff/coachEdit";
    }

    /**
     * 以下是POST方法的函数
     */

    private Record genRecord(int id, String op) {
        Record record = new Record();
        record.setId(id);
        record.setOperation(op);
        return record;
    }

    //TODO coachManage页面操作方法
    @PostMapping("/coachManage/add")
    public String addCoach(Coach coach, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        Integer er = staffService.insertCoach(coach);
        if (er != null && er > 0) {
            message = "添加教练成功,ID为：" + coach.getId();
            int id = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(id, "添加教练：" + coach.toString()));
        } else {
            message = "添加教练失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(coach.toString());
        return "redirect:/staff/coachManage";
    }

    @PostMapping("/coachManage/edit")
    public String editCoach(Coach coach, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        int er = staffService.updateCoach(coach);
        if (er > 0) {
            message = "修改教练成功";
            int id = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(id, "修改教练：" + coach.toString()));
        } else {
            message = "修改教练失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(coach.toString());
        return "redirect:/staff/coachManage";
    }

    @PostMapping("/coachManage/{id}/dismiss")
    public String dismissCoach(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Coach coach = new Coach();
        coach.setId(id);
        coach.setState("离职");
        Integer er = staffService.updateCoach(coach);
        String message = "";
        if (er != null && er > 0) {
            message = "" + coach.getId() + " 已离职";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "离职教练：" + coach.toString()));
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage";
    }

    @PostMapping("/coachManage/{id}/employ")
    public String employCoach(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Coach coach = new Coach();
        coach.setId(id);
        coach.setState("在职");
        Integer er = staffService.updateCoach(coach);
        String message = "";
        if (er != null && er > 0) {
            message = "" + id + " 已启用";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "启用教练：" + coach.toString()));
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage";
    }

    @PostMapping("/coachManage/{id}/update")
    public String updateCoach(@PathVariable("id") int id, Coach coach, HttpServletRequest request, RedirectAttributes attributes) {
        coach.setId(id);
        Integer er = staffService.updateCoach(coach);
        String message;
        if (er != null && er > 0) {
            message = "更新成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "更新教练：" + coach.toString()));
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/coachManage/" + id;
    }

    @PostMapping("/memberManage/{id}/cancel")
    public String cancelMember(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Member member = new Member();
        member.setId(id);
        member.setState("已注销");
        Integer er = staffService.updateMember(member);
        String message = "";
        if (er != null && er > 0) {
            message = "" + id + " 已注销";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "注销会员：" + member.toString()));
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/memberManage/";
    }

    @PostMapping("/memberManage/{id}/activate")
    public String activateMember(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Member member = new Member();
        member.setId(id);
        member.setState("有效");
        Integer er = staffService.updateMember(member);
        String message = "";
        if (er != null && er > 0) {
            message = "" + id + " 已激活";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "激活会员：" + member.toString()));
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/memberManage/";
    }

    @PostMapping("/memberManage/{id}/update")
    public String updateMember(@PathVariable("id") int id, Member member, HttpServletRequest request, RedirectAttributes attributes) {
        member.setId(id);
        Integer er = staffService.updateMember(member);
        String message;
        if (er != null && er > 0) {
            message = "更新成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "更新会员：" + member.toString()));
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/memberManage/" + id;
    }

    @PostMapping("/attendance/{cid}/{mid}")
    public String attendanceSign(@PathVariable("cid") int cid, @PathVariable("mid") int mid, HttpServletRequest request, RedirectAttributes attributes) {
        String message, day;
        Attendance attendance = new Attendance();
        attendance.setCourse_id(cid);
        attendance.setMember_id(mid);
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7) {
            message = "今天不是健身天";
            attributes.addFlashAttribute("message", message);
            return "redirect:/staff/attendance/" + cid;
        }
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 2:
                day = "周一";
                break;
            case 3:
                day = "周二";
                break;
            case 4:
                day = "周三";
                break;
            case 5:
                day = "周四";
                break;
            case 6:
                day = "周五";
                break;
            default:
                day = "";
        }
        Time_slot time_slot = staffService.getTimeSlotByTime(new Time(calendar.getTime(), day));
        if (time_slot == null) {
            message = "现在不在上课";
            attributes.addFlashAttribute("message", message);
            return "redirect:/staff/attendance/" + cid;
        } else {
            Course course = staffService.getCourseByID(cid);
            if (course.getTime_slot_id() != time_slot.getId()) {
                message = "现在不在上课";
                attributes.addFlashAttribute("message", message);
                return "redirect:/staff/attendance/" + cid;
            }
            Calendar cals = Calendar.getInstance();
            cals.setTime(time_slot.getStart_time());
            calendar.set(Calendar.HOUR, cals.get(Calendar.HOUR));
            calendar.set(Calendar.MINUTE, cals.get(Calendar.MINUTE));
            calendar.set(Calendar.SECOND, cals.get(Calendar.SECOND));
            calendar.set(Calendar.MILLISECOND, cals.get(Calendar.MILLISECOND));
            attendance.setDate_of_attendance(calendar.getTime());
            if (staffService.checkAttendance(attendance) != null) {
                message = "已经签到";
                attributes.addFlashAttribute("message", message);
                return "redirect:/staff/attendance/" + cid;
            }
            attendance.setDate_of_attendance(now);
        }
        System.out.println(attendance);
        Integer er = staffService.insertAttendance(attendance);
        if (er != null && er > 0) {
            message = "签到成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "签到：" + attendance.toString()));
        } else {
            message = "签到失败";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/attendance/" + cid;
    }


    //TODO memberManage页面操作方法
    @PostMapping("/memberManage/add")
    public String addMember(Member member, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        member.setPassword("member");
        System.out.println(member.toString());
        int id = staffService.insertMember(member);
        if (id > 0) {
            message = "添加会员成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "添加会员：" + member.toString()));
        } else {
            message = "添加会员失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(member.toString());
        return "redirect:/staff/memberManage";
    }

    @PostMapping("/memberManage/edit")
    public String editMember(Member member, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.updateMember(member);
        if (id > 0) {
            message = "修改会员成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "修改会员：" + member.toString()));
        } else {
            message = "修改会员失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(member.toString());
        return "redirect:/staff/memberManage";
    }

    //TODO attendance页面操作方法
    @PostMapping("/attendance/sign")
    public String attendanceSign(Attendance attendance, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.insertAttendance(attendance);
        if (id > 0) {
            message = "签到成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "签到：" + attendance.toString()));
        } else {
            message = "签到失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(attendance.toString());
        return "redirect:/staff/attendance";
    }

    //TODO courseManage页面操作方法
    @PostMapping("/courseManage/add")
    public String addCourse(Course course, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        Integer er = staffService.insertCourse(course);
        if (er != null && er > 0) {
            message = "添加课程成功，ID：" + course.getId();
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "添加课程：" + course.toString()));
        } else {
            message = "添加课程失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(course.toString());
        return "redirect:/staff/courseManage";
    }

    @PostMapping("/courseManage/edit")
    public String editCourse(Course course, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.updateCourse(course);
        if (id > 0) {
            message = "修改课程成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "修改课程：" + course.toString()));
        } else {
            message = "修改课程失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(course.toString());
        return "redirect:/staff/courseManage";
    }

    @PostMapping("/courseManage/{id}/cancel")
    public String cancelCourse(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes attributes) {
        Course course = new Course();
        course.setId(id);
        course.setState("已结课");
        Integer er = staffService.updateCourse(course);
        String message = "";
        if (er != null && er > 0) {
            message = "" + id + " 已取消";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "取消课程：" + course.toString()));
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/courseManage";
    }

    @PostMapping("/courseManage/{id}/update")
    public String cancelCourse(@PathVariable("id") int id, Course course, HttpServletRequest request, RedirectAttributes attributes) {
        course.setId(id);
        Integer er = staffService.updateCourse(course);
        System.out.println(course.toString());
        String message = "";
        if (er != null && er > 0) {
            message = "" + id + " 已更新";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "更新课程：" + course.toString()));
        } else {
            message = "更改失败，请稍后重试";
        }
        attributes.addFlashAttribute("message", message);
        return "redirect:/staff/courseManage/" + id;
    }

    //TODO chooseClass页面操作方法
    @PostMapping("/chooseClass/pick")
    public String pickClass(Take_course take_course, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        System.out.println(take_course);
        List<Course> courses = staffService.getCourseByMemberID(take_course.getMember_id());
        Course course = staffService.getCourseByID(take_course.getCourse_id());
        for (Course c : courses) {
            if (c.getTime_slot_id() == course.getTime_slot_id()) {
                message = "课程时间冲突";
                attributes.addFlashAttribute("message", message);
                System.out.println(take_course.toString());
                return "redirect:/staff/chooseClass";
            }
        }
        int id = staffService.insertTakeCourse(take_course);
        if (id > 0) {
            message = "选课成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "选课：" + take_course.toString()));
        } else {
            message = "选课失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(take_course.toString());
        return "redirect:/staff/chooseClass";
    }

    @GetMapping("/quitClass/{cid}")
    public String quitClassPage(@PathVariable("cid") int course_id, Model model) {
        List<CourseChosenItem> list = staffService.listCourseChosenItem(course_id);
        model.addAttribute("CourseChosenItemList", list);
//        System.out.println(list.size());
        return "/staff/courseQuit";
    }

    @PostMapping("/chooseClass/quit")
    public String quitClass(Take_course take_course, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.deleteTakeCourse(take_course);
        if (id > 0) {
            message = "退课成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "退课：" + take_course.toString()));
        } else {
            message = "退课失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(take_course.toString());
        return "redirect:/staff/chooseClass";
    }

    //TODO staffManage页面操作方法S
    @PostMapping("/staffManage/add")
    public String addStaff(Staff staff, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.insertStaff(staff);
        if (id > 0) {
            message = "添加员工成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "退课：" + staff.toString()));
        } else {
            message = "添加员工失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(staff.toString());
        return "redirect:/staff/staffManage";
    }

    @PostMapping("/staffManage/edit")
    public String editStaff(Course staff, HttpServletRequest request, RedirectAttributes attributes) {
        String message = "";
        int id = staffService.updateCourse(staff);
        if (id > 0) {
            message = "修改员工成功";
            int sid = ((Staff) request.getSession().getAttribute("loginUser")).getId();
            recordService.staffInsertRecord(genRecord(sid, "退课：" + staff.toString()));
        } else {
            message = "修改员工失败";
        }
        attributes.addFlashAttribute("message", message);
        System.out.println(staff.toString());
        return "redirect:/staff/staffManage";
    }
}
