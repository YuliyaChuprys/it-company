package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class ProjectOffer extends Document  {

    private BigDecimal price;
    private float executionTime;
    private Project project;
    private Team team;

    public ProjectOffer( int documentId, String documentTitle, BigDecimal price, float executionTime,
                         Project project, Team team){
        super(documentId, documentTitle);
        this.price = price;
        this.executionTime = executionTime;
        this.project = project;
        this.team = team;
    }

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
