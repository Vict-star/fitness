package com.software.fitness.component;

import com.software.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class RoutineTask {
    @Autowired
    private MemberService memberService;

    @Scheduled(cron = "0 10 0 * * ?")
    public void updateState() {
        memberService.updateMemberState();
        memberService.updateCourseState();
    }
}
