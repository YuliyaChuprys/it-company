package com.solvd.itcompany.domain;

import org.apache.logging.log4j.core.util.JsonUtils;

public class OfficeManager<C extends Cleaning<?, ?>, O extends OfficeManager<?, ?>> extends Worker<C, O> {

    public OfficeManager(String id, String firstName, boolean work, boolean uniform) {
        super(id, firstName, work, uniform);
    }

    public void generalClean(){
        System.out.println("General cleaning in the office");
    }

    @Override
    public String toString() {
        return "OfficeManager: " + getFirstName();
    }

}
