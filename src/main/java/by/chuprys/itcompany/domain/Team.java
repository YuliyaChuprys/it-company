package main.java.by.chuprys.itcompany.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Team {

    private int capacityPerMonth;
    private List<Developer> developers;
    private List<QA> qas;
    private ProjectManager projectManager;
    private LocalDateTime projectEnd;

    public Team(int capacityPerMonth, List<Developer> developers, List<QA> qas, ProjectManager projectManager) {
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

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<QA> getQas() {
        return qas;
    }

    public void setQas(List<QA> qas) {
        this.qas = qas;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    public LocalDateTime getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(LocalDateTime projectEnd) {
        this.projectEnd = projectEnd;
    }

    public String getTeamInfo() {
        return "Developers " + developers.size() +
                ", Testers " + qas.size() +
                ", Project Manager:" + projectManager.getFirstName() +
                " " + projectManager.getSecondName();
    }
}
