package main.java.by.chuprys.itcompany.domain;

public class OfficeManager extends Worker {

    public OfficeManager(String id, String firstName, boolean isWork, boolean uniform) {
        super(id, firstName, isWork, uniform);
    }

    @Override
    public String toString() {
        return "OfficeManager: " + getFirstName();
    }

}
