package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class Clining extends Woker {

    private String companyName;
    private String companyAddress;
    private int amountWorkDayPerWeek = 3;

    public Clining(String id, String firstName, boolean isWork, boolean uniform){
        super(id, firstName, isWork, uniform);
    }

    @Override
    public String toString(){
        return "Clining: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Clining clining = (Clining) o;

        return companyAddress.equals(clining.companyAddress);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + companyAddress.hashCode();
        return result;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public int getAmountWorkDayPerWeek() {
        return amountWorkDayPerWeek;
    }

    public void setAmountWorkDayPerWeek(int amountWorkDayPerWeek) {
        this.amountWorkDayPerWeek = amountWorkDayPerWeek;
    }
}
