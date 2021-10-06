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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
