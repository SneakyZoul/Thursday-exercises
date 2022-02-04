package Mapper2;


import DBConnector.DBConector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper {
    DBConector dbConector = new DBConector();

    public UserMapper(DBConector dbConector) {
        this.dbConector = dbConector;
    }


    public ArrayList<String> getUserName() throws Exception {
        ArrayList<String> name = new ArrayList<>();

        try {
            Connection connection = DBConector.connection();
            String sql = " SELECT fname FROM usertable ";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);
                while(rs.next()) {
                    String fname = rs.getString("fname");
                    name.add(fname);
                    System.out.println(fname);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return name;
    }

    public User getUserInfo(String name) throws Exception {
        User temp = null;

        try  {
            Connection connection = DBConector.connection();
            String sql = "SELECT * FROM usertable WHERE fname = ?";
            try {

                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1,name);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
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
