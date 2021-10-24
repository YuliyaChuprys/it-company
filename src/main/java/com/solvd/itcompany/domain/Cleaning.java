package com.solvd.itcompany.domain;

public class Cleaning<C extends Cleaning<?, ?>, O extends OfficeManager<?, ?>> extends Worker<C, O> {

    private String companyName;
    private String companyAddress;
    private int amountWorkDayPerWeek = 3;

    public Cleaning(String id, String firstName, boolean work, boolean uniform) {
        super(id, firstName, work, uniform);
    }

    @Override
    public String toString() {
        return "Cleaning: " + getFirstName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cleaning<?, ?> cleaning = (Cleaning<?, ?>) o;

        if (amountWorkDayPerWeek != cleaning.amountWorkDayPerWeek) return false;
        if (companyName != null ? !companyName.equals(cleaning.companyName) : cleaning.companyName != null)
            return false;
        return companyAddress != null ? companyAddress.equals(cleaning.companyAddress) : cleaning.companyAddress == null;
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
