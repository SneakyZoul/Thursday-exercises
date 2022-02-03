package Mapper2;

public class User {
    int id;
    String fname;
    String lname;
    String address;
    String phone;
    String pw;

    public User() {

    }

    public User(String fname) {
        this.fname = fname;
    }

    public User(String fname, String lname, String phone, String address) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
    }

    public User(String fname, String lname, String address, String phone, String pw) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phone = phone;
        this.pw = pw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return fname;
    }

    public void setName(String name) {
        this.fname = name;
    }

    public String getLastName() {
        return lname;
    }

    public void setLastName(String lastName) {
        this.lname = lastName;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return pw;
    }

    public void setPassword(String password) {
        this.pw = password;
    }
}
