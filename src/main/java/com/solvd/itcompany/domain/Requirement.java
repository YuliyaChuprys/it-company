package com.solvd.itcompany.domain;

import java.time.LocalDate;

public class Requirement extends Document {

    private int features;
    private LocalDate startProjectDate;


    public Requirement(int documentId, String documentTitle, int features, LocalDate startProjectDate) {
        super(documentId, documentTitle);
        this.features = features;
        this.startProjectDate = startProjectDate;
    }

    @Override
    public String toString() {
        return "Document: " + getDocumentTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Requirement that = (Requirement) o;

        if (features != that.features) return false;
        return startProjectDate.equals(that.startProjectDate);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + features;
        result = 31 * result + startProjectDate.hashCode();
        return result;
    }

    public void setFeatures(int features) {
        this.features = features;
    }

    public int getFeatures() {
        return features;
    }

    public void setStartProjectDate(LocalDate startProjectDate) {
        this.startProjectDate = startProjectDate;
    }

    public LocalDate getStartProjectDate() {
        return startProjectDate;
    }


}
