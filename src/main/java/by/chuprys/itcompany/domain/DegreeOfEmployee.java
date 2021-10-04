package main.java.by.chuprys.itcompany.domain;

public class DegreeOfEmployee {

    private int workExperienceMonth;
    private int rating;
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

    public DegreeOfEmployee(int workExperienceMonth, int rating) {
        this.workExperienceMonth = workExperienceMonth;
        this.rating = rating;
    }

    public DegreeOfEmployee(int workExperienceMonth) {
        this(workExperienceMonth, 0);
    }

    public float getWorkExperienceMonth() {
        return workExperienceMonth;
    }

    public void setWorkExperienceMonth(int workExperienceMonth) {
        this.workExperienceMonth = workExperienceMonth;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}

