package main.java.by.chuprys.itcompany.domain;

import main.java.by.chuprys.itcompany.exeption.InvalidDocumentData;

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

    @Override
    public String setDocumentDescription() {
        return null;
    }

    @Override
    public int getDocumentId() {
        return documentId;
    }

    @Override
    public String getDocumentTitle() {
        return documentTitle;
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

    public void setDocumentId(int documentId) {
        try{
        if (documentId == 000){
            throw new InvalidDocumentData("Document ID is invalid");
        }
        }
        catch(InvalidDocumentData e) {
            System.out.println("Document Description is invalid");
        } finally {
            System.out.println("After operation1");
        }
        this.documentId = documentId;
    }

    @Override
   public void setDocumentTitle(String documentTitle) {
       if ( documentTitle.contains("Report") ){
           throw new InvalidDocumentData("Document Title is invalid");
       }
        this.documentTitle = documentTitle;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    @Override
    public void setDocumentDescription(String documentDescription) {
        if ( documentDescription.contains("@")| documentDescription.contains("-") | documentDescription.contains("#")|
                documentDescription.contains("$")| documentDescription.contains("%")| documentDescription.contains("^")|
                documentDescription.contains("&")| documentDescription.contains("*")| documentDescription.contains("="))
        {
            throw new InvalidDocumentData("Document description is invalid");
        }
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

    @Override
    public void setDocumentAuthor(String documentAuthor) {
        if (documentAuthor.contains("2")){
            throw new InvalidDocumentData("Invalid Document Author");
        }
        this.documentAuthor = documentAuthor;
    }

}
