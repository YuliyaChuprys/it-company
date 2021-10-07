package main.java.by.chuprys.itcompany.domain;

public abstract class Specialist extends Employee {

    private String departmentName;

    public Specialist(String id, String firstName, boolean isWork, String departmentName){
        super(id, firstName, isWork);
        this.departmentName = departmentName;
    }

    @Override
    public void sendWelcomMassage(){
        System.out.println("Welcome to Best Company Specialist department!");
    };

    @Override
    public String toString(){
        return "Secialist: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Specialist that = (Specialist) o;

        return departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        return result;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
