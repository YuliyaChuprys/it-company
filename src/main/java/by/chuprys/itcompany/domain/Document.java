package main.java.by.chuprys.itcompany.domain;

public class Document implements IDocumentAction {

    private int documentId;
    private String documentTitle;
    private String documentDescription;
    private boolean isInternal;
    private String documentAuthor;

    public Document(int documentId, String documentTitle) {
        this.documentId = documentId;
        this.documentTitle = documentTitle;
    }

    @Override
    public String toString() {
        return "Document title: " + documentTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (documentId != document.documentId) return false;
        return documentTitle.equals(document.documentTitle);
    }

    @Override
    public int hashCode() {
        return documentId;
    }

    @Override
    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    @Override
    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public boolean isInternal() {
        return isInternal;
    }

    public void setInternal(boolean internal) {
        isInternal = internal;
    }

    public String getDocumentAuthor() {
        return documentAuthor;
    }

    public void setDocumentAuthor(String documentAuthor) {
        this.documentAuthor = documentAuthor;
    }

    @Override
    public void docPrint() {
        System.out.println("Document was printed. Document ID: " + documentId + ". Document title: " + documentTitle);
    }

    @Override
    public void docSendByFax() {
        System.out.println("Document was send by fax: " + documentId + documentTitle);

    }

    @Override
    public void docSendByEmail() {
        System.out.println("Document was send by Email: " + documentId + documentTitle);

    }
}
