package com.solvd.itcompany.service;

import com.solvd.itcompany.domain.Educable;

public class EducationService implements IEducationService {

    @Override
    public void upLevelToMiddle(Educable educable) {
        System.out.println("Lessons for Juniors were passed");
        educable.educate("middle");
    }

    @Override
    public void upLevelToSenior(Educable educable) {
        System.out.println("Lessons for Middles were passed");
        educable.educate("senior");
    }

}
