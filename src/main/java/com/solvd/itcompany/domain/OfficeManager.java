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

    public void treatСolleagues() {
        if (this.getDayWeek() == DayWeek.FRI) {
            System.out.println("We invite you to the kitchen!");
        }
    }

    @Override
    public String toString() {
        return "OfficeManager: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OfficeManager<?, ?> that = (OfficeManager<?, ?>) o;

        return dayWeek == that.dayWeek;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (dayWeek != null ? dayWeek.hashCode() : 0);
        return result;
    }
}
