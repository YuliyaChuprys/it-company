package main.java.by.chuprys.itcompany.domain;

import java.math.BigDecimal;

public class OfficeManager extends Woker {

    public OfficeManager(String id, String firstName, boolean isWork, boolean uniform){
        super(id, firstName, isWork, uniform);
    }

    @Override
    public String toString(){
        return "OfficeManager: " + getFirstName();
    }

}
