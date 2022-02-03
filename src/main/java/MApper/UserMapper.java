package MApper;

import DBConnector.DBConector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserMapper {
    DBConector dbConector = new DBConector();


    public void getUsername(User user) throws Exception {
        String tmpUser = null;
        try (
                Connection connection = DBConector.connection()) {

            String sql = " SELECT * FROM usertable WHERE fname = '" + User.name + "'";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery(sql);
                if (rs.next()) {
                    String fname = rs.getString("fname");
                    String lname = rs.getString("lname");
                    String pw = rs.getString("pw");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");

                    System.out.println(fname);


                }
            }
        }
    }
}
