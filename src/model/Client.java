package model;

public class Client {

    private int id;
    private String fullName;
    private String phone;
    private String passport;
    private String email;

    @Override
    public String toString() {
        return id + " " + email + " " + fullName + " " + phone + " " + passport;
    }

    public Client(String fullName, String phone, String passport, String email) {
        this.fullName = fullName;
        this.phone = phone;
        this.passport = passport;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
