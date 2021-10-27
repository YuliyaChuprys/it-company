package com.solvd.itcompany.domain;

public class OfficeManager<C extends Cleaning<?, ?>, O extends OfficeManager<?, ?>> extends Worker<C, O> {

    private DayWeek dayWeek;

    public OfficeManager(String id, String firstName, boolean work, boolean uniform) {
        super(id, firstName, work, uniform);
    }

    public DayWeek getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(DayWeek dayWeek) {
        this.dayWeek = dayWeek;
    }

    @Override
    public String toString() {
        return "OfficeManager: " + getFirstName();
    }

}
