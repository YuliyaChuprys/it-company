package main.java.by.chuprys.itcompany.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Team {

    private int capacityPerMonth;
    private Set<Developer> developers;
    private Set<QA> qas;
    private ProjectManager projectManager;
    private LocalDateTime projectEnd;

    public Team(int capacityPerMonth, Set<Developer> developers, Set<QA> qas, ProjectManager projectManager) {
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

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<QA> getQas() {
        return qas;
    }

    public void setQas(Set<QA> qas) {
        this.qas = qas;
    }

    public ProjectManager getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    public String getTeamInfo() {
        return "Developers " + developers.size() +
                ", Testers " + qas.size() +
                ", Project Manager:" + projectManager.getFirstName() +
                " " + projectManager.getSecondName();
    }
}
