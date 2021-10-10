package main.java.by.chuprys.itcompany.domain;

public interface IDocumentAction {

    void docPrint();

    void docSendByFax();

    void docSendByEmail();

    int getDocumentId();

    String getDocumentTitle();
}
