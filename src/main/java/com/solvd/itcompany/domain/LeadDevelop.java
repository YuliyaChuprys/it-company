package com.solvd.itcompany.domain;

public class LeadDevelop<PM extends ProjectManager<?, ?, ?>, LD extends LeadDevelop<?, ?, ?>, LQ extends LeadQa<?, ?, ?>>
        extends Manager<PM, LD, LQ> {

    private String language;
    private boolean onProject;

    public LeadDevelop(String id, String firstName, boolean work, String departmentName) {
        super(id, firstName, work, departmentName);
    }

    @Override
    public String toString() {
        return "Lead of Develop department: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LeadDevelop<?, ?, ?> that = (LeadDevelop<?, ?, ?>) o;

        if (onProject != that.onProject) return false;
        return language != null ? language.equals(that.language) : that.language == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOnProject() {
        return onProject;
    }

    public void setOnProject(boolean onProject) {
        this.onProject = onProject;
    }

}
