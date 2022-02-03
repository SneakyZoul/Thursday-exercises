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

}
