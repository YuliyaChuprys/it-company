package main.java.by.chuprys.itcompany.domain;

import java.time.LocalDate;

public class Requirement {

    private int features;
    private String description;
    private LocalDate startProjectDate;


    public Requirement(int features, String description, LocalDate startProjectDate) {
        this.features = features;
        this.description = description;
        this.startProjectDate = startProjectDate;
    }

    public void setFeatures(int features){
        this.features = features;
    }

    public int getFeatures(){
        return features;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setStartProjectDate(LocalDate startProjectDate){
        this.startProjectDate = startProjectDate;
    }

    public LocalDate getStartProjectDate(){
        return startProjectDate;
    }


}
