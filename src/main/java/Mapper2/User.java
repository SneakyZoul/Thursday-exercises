package Mapper2;

import java.util.Objects;

public class User {
    int id;
    String fname;
    String lname;
    String address;
    String phone;
    String pw;

    public User() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(fname, user.fname) && Objects.equals(lname, user.lname) && Objects.equals(address, user.address) && Objects.equals(phone, user.phone);
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname, address, phone);
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

    public User(String fname, String lname,String pw, String phone, String address) {
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
