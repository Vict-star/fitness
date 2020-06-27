package com.software.fitness.dao;

import com.software.fitness.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberDao {

    Member getMemberByPhoneNumber(String phone_number);

    Integer insert(Member member);

    Integer update(Member member);

    Integer delete(Member member);

    List<Member> getAllMember();

    Member getMemberByID(int id);

    @Deprecated
    Integer increaseNumberOfCourse(int id);

    @Deprecated
    Integer decreaseNumberOfCourse(int id);

    List<Member> getMemberByCourseID(int id);

    Integer updateValidityState();

    Integer updateInvalidityState();
}
