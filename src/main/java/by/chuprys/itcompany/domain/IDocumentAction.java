package main.java.by.chuprys.itcompany.domain;

public interface IDocumentAction {

    void docPrint();

    int getDocumentId();

    String getDocumentTitle();

    void docSendByFax();

    void docSendByEmail();

}
