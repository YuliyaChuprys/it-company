package main.java.by.chuprys.itcompany.domain;

public class Customer {

    private String companyName;
    private String phone;
    private String contactName;
    private String companyEmail;
    private String account;

    public Customer(String companyName, String phone, String contactName, String companyEmail) {
        this.companyName = companyName;
        this.phone = phone;
        this.contactName = contactName;
        this.companyEmail = companyEmail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
