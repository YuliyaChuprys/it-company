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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ProjectOffer that = (ProjectOffer) o;

        if (Float.compare(that.executionTime, executionTime) != 0) return false;
        if (!price.equals(that.price)) return false;
        if (!project.equals(that.project)) return false;
        return team.equals(that.team);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + (executionTime != +0.0f ? Float.floatToIntBits(executionTime) : 0);
        result = 31 * result + project.hashCode();
        result = 31 * result + team.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ProjectOffer{" +
                "price=" + price +
                ", executionTime=" + executionTime +
                ", project=" + project +
                ", team=" + team +
                '}';
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
