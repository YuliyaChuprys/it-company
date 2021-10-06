package main.java.by.chuprys.itcompany.domain;

public class LeadDevelop extends Manager{

    private String language;
    private boolean isOnProject;

    public LeadDevelop(String id, String firstName, boolean isWork, String departmentName) {
        super(id, firstName, isWork, departmentName);
        this.isOnProject = isOnProject;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOnProject() {
        return isOnProject;
    }

    public void setOnProject(boolean onProject) {
        isOnProject = onProject;
    }
}
