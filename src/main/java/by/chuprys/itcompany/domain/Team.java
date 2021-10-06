package main.java.by.chuprys.itcompany.domain;

import java.time.LocalDateTime;

public class Team {

    private int capacityPerMonth;
    private Developer[] developers;
    private QA[] qas;
    private ProjectManager projectManager;
    private LocalDateTime projectEnd;

    public Team(int capacityPerMonth, Developer[] developers, QA[] qas, ProjectManager projectManager) {

        this.capacityPerMonth = capacityPerMonth;
        this.developers = developers;
        this.qas = qas;
        this.projectManager = projectManager;

    }

    public int getCapacityPerMonth() {
        return capacityPerMonth;
    }

    public void setCapacityPerMonth(int capacityPerMonth) {
        this.capacityPerMonth = capacityPerMonth;
    }

    public Developer[] getDevelopers() {
        return developers;
    }

    public void setDevelopers(Developer[] developers) {
        this.developers = developers;
    }

    public QA[] getQas() {
        return qas;
    }

    public void setQas(QA[] qas) {
        this.qas = qas;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    public String getTeamInfo() {
        return "Developers " + developers.length +
                ", Testers " + qas.length +
                ", Project Manager:" + projectManager.getFirstName() +
                " " + projectManager.getSecondName();
    }
}
