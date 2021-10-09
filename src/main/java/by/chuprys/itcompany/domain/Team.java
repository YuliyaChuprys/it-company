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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (capacityPerMonth != team.capacityPerMonth) return false;
        if (!projectManager.equals(team.projectManager)) return false;
        return projectEnd.equals(team.projectEnd);
    }

    @Override
    public int hashCode() {
        int result = capacityPerMonth;
        result = 31 * result + projectManager.hashCode();
        result = 31 * result + projectEnd.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "projectManager=" + projectManager +
                ", projectEnd=" + projectEnd +
                '}';
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
