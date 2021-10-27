package com.solvd.itcompany.domain;

public enum DayWeek {

    MON("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),
    SUN("Sunday");

    private final String dayWeek;

    DayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public String getDayWeek() {
        return dayWeek;
    }
}


