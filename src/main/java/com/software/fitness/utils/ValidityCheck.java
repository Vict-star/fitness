package com.software.fitness.utils;

import com.software.fitness.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;

public class ValidityCheck extends TimerTask {
    @Autowired
    private StaffService staffService;

    @Override
    public void run() {
        staffService.getAllMember();
    }

}
