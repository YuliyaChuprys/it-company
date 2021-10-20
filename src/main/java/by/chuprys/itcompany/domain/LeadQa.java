package by.chuprys.itcompany.domain;

public class LeadQa<PM extends ProjectManager, LD extends LeadDevelop, LQ extends LeadQa>
        extends Manager<PM, LD, LQ> {

    private boolean manual;
    private boolean isOnProject;

    public LeadQa(String id, String firstName, boolean isWork, String departmentName) {
        super(id, firstName, isWork, departmentName);
    }

    @Override
    public String toString() {
        return "Lead of Testing department: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LeadQa leadQa = (LeadQa) o;

        return manual == leadQa.manual;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (manual ? 1 : 0);
        return result;
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
