package com.software.fitness.utils;

import com.software.fitness.domain.Member;
import com.software.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;

public class ValidityCheck extends TimerTask {
    @Autowired
    private MemberService memberService;
    private Member[] members;

    @Override
    public void run() {
        members = memberService.getValidityMember();
        for (Member m : members) {
            m.setPassword(null);
            m.setNumber_of_course(-1);
            m.setState("有效");
            m.setValidity(null);
            m.setPhone_number(null);
            m.setName(null);
            m.setGender(null);
            m.setDate_of_birth(null);
            memberService.updateMember(m);
        }

        members = memberService.getInvalidityMember();
        for (Member m : members) {
            m.setPassword(null);
            m.setNumber_of_course(-1);
            m.setState("已过期");
            m.setValidity(null);
            m.setPhone_number(null);
            m.setName(null);
            m.setGender(null);
            m.setDate_of_birth(null);
            memberService.updateMember(m);
        }
    }

}
