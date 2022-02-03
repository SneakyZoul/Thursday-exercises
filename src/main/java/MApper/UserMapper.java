package MApper;

import DBConnector.DBConector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    DBConector dbConector = new DBConector();

    public User getUsername() throws Exception {
        User user = new User();
        User temp = null;

        try (Connection connection = DBConector.connection()) {

            String sql = " SELECT * FROM usertable WHERE fname = '" + user.name + "'";
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

            String sql = " SELECT * FROM usertable WHERE id= '" + user.name + user.lastName + user.password + user.phone + user.address + "'";
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

                    temp = new User(fname,lname,phone,address);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

}
