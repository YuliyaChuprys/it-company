package com.solvd.itcompany.domain;

public class Specialist extends Employee implements Educable {

    private String departmentName;

    public Specialist(String id, String firstName, boolean work, String departmentName) {
        super(id, firstName, work);
        this.departmentName = departmentName;
    }

    @Override
    public void educate(String level) {
        System.out.println("Education in progress ");
        super.setRating(level);
    }

    @Override
    public String getLevel() {
        return super.getRating();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public void sendWelcomeMessage() {
        System.out.println("Welcome to Best Company Specialist department!");
    }

    @Override
    public String toString() {
        return "Specialist: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Specialist that = (Specialist) o;

        return departmentName != null ? departmentName.equals(that.departmentName) : that.departmentName == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        return result;
    }

}
