package com.software.fitness.service.Impl;

import com.software.fitness.dao.CoachDao;
import com.software.fitness.dao.CourseDao;
import com.software.fitness.dao.MemberDao;
import com.software.fitness.dao.Take_courseDao;
import com.software.fitness.domain.Coach;
import com.software.fitness.domain.Course;
import com.software.fitness.domain.Member;
import com.software.fitness.domain.Take_course;
import com.software.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private CoachDao coachDao;
    
    @Autowired
    private CourseDao courseDao;
    
    @Autowired
    private MemberDao memberDao;
    
    @Autowired
    private Take_courseDao take_courseDao;

    @Override
    public Integer addCoach(Coach coach) {
        Integer id = -1;
        id = coachDao.addCoach(coach);
        return id;
    }

    @Override
    public List<Coach> coachPage() {
        return coachDao.listCoach();
    }

    @Override
    public boolean dismissCoach(int id) {
        Coach coach = coachDao.getCoach(id);
        coach.setState("离职");
        int row  = coachDao.updateCoach(coach);
        return row == 1;
    }

    @Override
    public boolean employCoach(Integer id) {
        Coach coach = coachDao.getCoach(id);
        coach.setState("在职");
        int row  = coachDao.updateCoach(coach);
        return row == 1;
    }

    @Override
    public Coach getCoach(int id) {
        return coachDao.getCoach(id);
    }

    @Override
    public boolean updateCoach(Coach coach) {
        int row = coachDao.updateCoach(coach);
        return row == 1;
    }

    
    
    
    
	@Override
	public Member getMemberById(int id) {
		return memberDao.getMemberByID(id);
	}

	@Override
	public Course getCourseById(int id) {
		return courseDao.getCourseById(id);
	}

	@Override
	public List<Course> coursePage() {
		return courseDao.listCourse();
	}

	@Override
	public Integer addCourse(Course course) {
        Integer id = -1;
        id = courseDao.addCourse(course);
        return id;
	}

	@Override
	public boolean updateCourse(Course course) {
        int row = courseDao.updateCourse(course);
        return row == 1;
	}

	@Override
	public boolean deleteCourse(int id) {
		int row = courseDao.deleteCourse(id);
		return row == 1;
	}

	@Override
	public List<Take_course> getTakeByMemberid(int ID) {
		return take_courseDao.getTakeByMemberId(ID);
	}

	@Override
	public List<Take_course> getTakeByCourseid(int ID) {
		return take_courseDao.getTakeByCourseId(ID);
	}

	@Override
	public List<Take_course> getTakeAll() {
		return take_courseDao.getTakeAll();
	}

	@Override
	public boolean addTake(Take_course take_course) {
		int row = take_courseDao.insert(take_course);
		return row == 1;
	}

	@Override
	public boolean deleteTake(Take_course take_course) {
		int row = take_courseDao.delete(take_course);
		return row == 1;
	}


}
