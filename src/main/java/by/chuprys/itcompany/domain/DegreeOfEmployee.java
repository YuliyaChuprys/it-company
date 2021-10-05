package main.java.by.chuprys.itcompany.domain;

public class DegreeOfEmployee {
    private int workExperienceMonth;
    String level = getlevelEmployee(); //"junior"(<12), "middle"12<24, "senior">36

    public String getlevelEmployee() {
        if (workExperienceMonth < 0) {
            System.out.println("Опыт работы для работкина указан неверно:" + workExperienceMonth);
        }

        if (workExperienceMonth < 12) {
            level = "junior";
        }
        if (workExperienceMonth > 24 & workExperienceMonth < 36) {
            level = "middle";
        } else level = "senior";
        return level;
    }

    public float getWorkExperienceMonth() {
        return workExperienceMonth;
    }

    public void setWorkExperienceMonth(int workExperienceMonth) {
        this.workExperienceMonth = workExperienceMonth;
    }

}

