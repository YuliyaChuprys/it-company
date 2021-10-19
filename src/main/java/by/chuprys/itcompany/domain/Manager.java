package by.chuprys.itcompany.domain;

import java.math.BigDecimal;
import java.util.List;

public class Manager<PM extends ProjectManager, LD extends LeadDevelop, LQ extends LeadQa>
        extends Employee implements Educable {

    private String departmentName;
    private float salaryBonus;
    private BigDecimal salaryPerMonth;
    private List<PM> projectManager;
    private List<LD> leadDeveloper;
    private List<LQ> leadQa;

    public Manager(String id, String firstName, boolean isWork, String departmentName) {
        super(id, firstName, isWork);
        this.departmentName = departmentName;
    }

    @Override
    public void educate(String level) {
        System.out.println("Education in progress ");
        super.setRating(level);
    }

    @Override
    public String getLevel() {
        return super.getRating();
    }

    @Override
    public String toString() {
        return "Manager: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manager manager = (Manager) o;

        return departmentName.equals(manager.departmentName);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + departmentName.hashCode();
        return result;
    }

    public List<PM> getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(List<PM> projectManager) {
        this.projectManager = projectManager;
    }

    public List<LD> getLeadDeveloper() {
        return leadDeveloper;
    }

    public void setLeadDeveloper(List<LD> leadDeveloper) {
        this.leadDeveloper = leadDeveloper;
    }

    public List<LQ> getLeadQa() {
        return leadQa;
    }

    public void setLeadQa(List<LQ> leadQa) {
        this.leadQa = leadQa;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public float getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(float salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    public BigDecimal getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(BigDecimal salaryPerMonth) {
        this.salaryPerMonth = salaryPerMonth;
    }

}
