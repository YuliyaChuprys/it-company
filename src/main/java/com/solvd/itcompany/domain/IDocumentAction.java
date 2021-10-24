package com.solvd.itcompany.domain;

public interface IDocumentAction {

    void docPrint();

    int getDocumentId();

    String getDocumentTitle();

    void docSendByFax();

    void docSendByEmail();

    String setDocumentDescription();

    void setDocumentAuthor(String documentTitle);

    void setDocumentTitle(String documentTitle);

    void setDocumentDescription(String documentDescription);

}
