package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class ProjectOffer {

    private BigDecimal price;
    private float executionTime;
    private Project project;
    private Team team;

    public ProjectOffer(BigDecimal price, float executionTime, Project project, Team team){

        this.price = price;
        this.executionTime = executionTime;
        this.project = project;
        this.team = team;
    }

    // public String toString(){
    //    return "Стоимость проекта: " + getPrice() + ", Время выполнения(мес): " + getExecutionTime();
    //}


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public float getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(float executionTime) {
        this.executionTime = executionTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
