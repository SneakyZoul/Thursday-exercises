package Mapper2;


import DBConnector.DBConector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    DBConector dbConector = new DBConector();

    public UserMapper(DBConector dbConector) {
        this.dbConector = dbConector;
    }


    public User getUsername() throws Exception {
        User user = new User();
        User temp = null;

        try (Connection connection = DBConector.connection()) {

            String sql = " SELECT * FROM usertable WHERE fname = '" + user.fname + "'";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    String fname = rs.getString("fname");


                    System.out.println(fname);
                    temp = new User(fname);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public User getUserInfo() throws Exception {
        User user = new User();
        User temp = null;

        try (Connection connection = DBConector.connection()) {

            String sql = " SELECT * FROM usertable WHERE id= '" + user.fname + user.lname + user.pw + user.phone + user.address + "'";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    String pw = rs.getString("pw");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");


                    System.out.println(fname);
                    System.out.println(lname);
                    System.out.println(phone);
                    System.out.println(address);

                    temp = new User(fname, lname, phone, address);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void editUser(User user) {

        try (Connection connection = DBConector.connection()) {
            String sql = "UPDATE user SET fname=?, lname=?,pw=?,phone=?, address=? WHERE user_id='" + user.getId() + "'";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, user.getName());
                ps.setString(2, user.getLastName());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getPhone());
                ps.setString(5, user.getAdress());
                ps.executeUpdate();


            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
