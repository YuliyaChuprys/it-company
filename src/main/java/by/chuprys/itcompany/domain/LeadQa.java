package main.java.by.chuprys.itcompany.domain;

public class LeadQa extends Manager{

    private boolean manual;
    private boolean isOnProject;

    public LeadQa(String id, String firstName, boolean isWork, String departmentName) {
        super(id, firstName, isWork, departmentName);
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public boolean isOnProject() {
        return isOnProject;
    }

    public void setOnProject(boolean onProject) {
        isOnProject = onProject;
    }
}
