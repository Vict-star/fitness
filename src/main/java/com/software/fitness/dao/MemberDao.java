package com.software.fitness.dao;

import com.software.fitness.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberDao {

    Member getMemberByPhoneNumber(String phone_number);

    Integer insert(Member member);

    Integer update(Member member);

    Integer delete(Member member);

    Member[] getAllMember();

    Member getMemberByID(int id);

    @Deprecated
    Integer increaseNumberOfCourse(int id);

    @Deprecated
    Integer decreaseNumberOfCourse(int id);

    Member[] getMemberByCourseID(int id);

    Member[] getInvalidityMember();

    Member[] getValidityMember();
}
