package com.software.fitness.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.software.fitness.dao.*;
import com.software.fitness.domain.*;
import com.software.fitness.page.PageRequest;
import com.software.fitness.page.PageResult;
import com.software.fitness.service.StaffService;
import com.software.fitness.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private CoachDao coachDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private Take_courseDao take_courseDao;
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private Time_slotDao time_slotDao;


    @Override
    public Staff getStaffByPhoneNumber(String phone_number) {
        return staffDao.getStaffByPhoneNumber(phone_number);
    }

    @Override
    public Integer insertStaff(Staff staff) {
        return staffDao.insert(staff);
    }

    @Override
    public Integer updateStaff(Staff staff) {
        return staffDao.update(staff);
    }

    @Override
    public Integer deleteStaff(Staff staff) {
        return staffDao.delete(staff);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public Integer insertCoach(Coach coach) {
        return coachDao.insert(coach);
    }

    @Override
    public Integer updateCoach(Coach coach) {
        return coachDao.update(coach);
    }

    @Override
    public Integer deleteCoach(Coach coach) {
        return coachDao.delete(coach);
    }

    @Override
    public List<Coach> getAllCoach() {
        return coachDao.getAllCoach();
    }

    @Override
    public Coach getCoachByID(int id) {
        return coachDao.getCoachByID(id);
    }

    @Override
    public Integer insertMember(Member member) {
        return memberDao.insert(member);
    }

    @Override
    public Integer updateMember(Member member) {
        return memberDao.update(member);
    }

    @Override
    public Integer deleteMember(Member member) {
        return memberDao.delete(member);
    }

    @Override
    public Member getMemberByID(int id) {
        return memberDao.getMemberByID(id);
    }

    @Override
    public Member getMemberByPhoneNumber(String phone_number) {
        return memberDao.getMemberByPhoneNumber(phone_number);
    }

    @Override
    public List<Member> getMemberByCourseID(int id) {
        return memberDao.getMemberByCourseID(id);
    }

    @Override
    public Integer increaseNumberOfCourses(int id) {
        return memberDao.increaseNumberOfCourse(id);
    }

    @Override
    public Integer decreaseNumberOfCourses(int id) {
        return memberDao.decreaseNumberOfCourse(id);
    }

    @Override
    public List<Member> getAllMember() {
        return memberDao.getAllMember();
    }

    @Override
    public Integer insertCourse(Course course) {
        return courseDao.insert(course);
    }

    @Override
    public Integer updateCourse(Course course) {
        return courseDao.update(course);
    }

    @Override
    public Integer deleteCourse(Course course) {
        return courseDao.delete(course);
    }

    @Override
    public Course getCourseByID(int id) {
        return courseDao.getCourseByID(id);
    }

    @Override
    public Integer increaseNumberOfMember(int id) {
        return courseDao.increaseNumberOfMember(id);
    }

    @Override
    public Integer decreaseNumberOfMember(int id) {
        return courseDao.decreaseNumberOfMember(id);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public List<Course> getCourseByState(String state) {
        return courseDao.getCourseByState(state);
    }

    @Override
    public Integer insertTimeSlot(Time_slot time_slot) {
        return time_slotDao.insert(time_slot);
    }

    @Override
    public Integer updateTimeSlot(Time_slot time_slot) {
        return time_slotDao.update(time_slot);
    }

    @Override
    public Integer deleteTimeSlot(Time_slot time_slot) {
        return time_slotDao.delete(time_slot);
    }

    @Override
    public List<Time_slot> getAllTimeSlot() {
        return time_slotDao.getAllTimeSlot();
    }

    @Override
    public Integer insertAttendance(Attendance attendance) {
        return attendanceDao.insert(attendance);
    }

    @Override
    public Integer deleteAttendance(Attendance attendance) {
        return attendanceDao.delete(attendance);
    }

    @Override
    public Integer insertTakeCourse(Take_course take_course) {
        return take_courseDao.insert(take_course);
    }

    @Override
    public Integer deleteTakeCourse(Take_course take_course) {
        return take_courseDao.delete(take_course);
    }

    @Override
    public PageResult getMemberPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public List<Course> getCourseByDate(Date date) {
        return courseDao.getCourseByDate(date);
    }

    @Override
    public List<Course> getCourseByMemberID(int id) {
        return courseDao.getCourseByMemberID(id);
    }

    private PageInfo<Member> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Member> members = memberDao.getAllMember();
        return new PageInfo<Member>(members);
    }

    @Override
    public List<CourseTableItem> listCourseTableItem() {
        return courseDao.listCourseTableItem();
    }

    @Override
    public List<CourseChosenItem> listCourseChosenItem(Integer course_id) {
        return take_courseDao.listCourseChosenItem(course_id);
    }

    @Override
    public PageInfo<Coach> PageAllCoach(int page, int pageSize) {
        PageHelper.startPage(1, 2);
        List<Coach> coachlist = coachDao.getAllCoach();
        PageInfo pageInfo = new PageInfo(coachlist);
        return pageInfo;
    }

    @Override
    public boolean changePassword(String phone_number, String staffId, String old_pwd, String new_pwd) {
        Staff staff = staffDao.getStaffByPhoneNumber(phone_number);
        if (staff.getPassword().equals(old_pwd)) {
            staff.setPassword(new_pwd);
            int row = staffDao.update(staff);
            return row > 0;
        } else {
            return false;
        }
    }

    @Override
    public Time_slot getTimeSlotByTime(Time time) {
        return time_slotDao.getTimeSlotByTime(time);
    }

    @Override
    public Attendance checkAttendance(Attendance attendance) {
        return attendanceDao.checkAttendance(attendance);
    }

    @Override
    public boolean staffDetailUpdate(String id, String name, String phone_number, String address) {
        Staff staff = staffDao.getStaffByPhoneNumber(phone_number);
        staff.setPhone_number(phone_number);
        staff.setAddress(address);
        staff.setName(name);
        int row = staffDao.update(staff);
        return row > 0;
    }
}
