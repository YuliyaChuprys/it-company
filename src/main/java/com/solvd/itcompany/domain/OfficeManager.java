package com.solvd.itcompany.domain;

public class OfficeManager<C extends Cleaning<?, ?>, O extends OfficeManager<?, ?>> extends Worker<C, O> {

    public OfficeManager(String id, String firstName, boolean work, boolean uniform) {
        super(id, firstName, work, uniform);
    }

    @Override
    public String toString() {
        return "OfficeManager: " + getFirstName();
    }

}
