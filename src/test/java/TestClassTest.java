import DBConnector.DBConector;
import Mapper2.User;
import Mapper2.UserMapper;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClassTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("TESTINNNNGGGG");
        Connection con = null;
        try {
            con = DBConector.connection();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5, "Rolighedsvej 3");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void getName() throws Exception {
        DBConector dbConector = new DBConector();
         UserMapper instance = new UserMapper(dbConector);
        String expected = "Hans";
        User actual = instance.getUsername();
        assertEquals(expected, actual);

    }
    @Test
    public void getUserInfo() throws Exception {
        DBConector dbConector= new DBConector();
        UserMapper instance = new UserMapper(dbConector);
        String expected = "Hans Hansen Hemmelig123 40404040 Rolighedsvej 3";
        User actual = instance.getUserInfo();
        assertEquals(expected, actual);
    }
    /*@Test
    public void editUser() throws Exception{
        DBConector dbConector = new DBConector();
        UserMapper instance = new UserMapper(dbConector);
        String expected = "Hans Hansen Hemmelig123 40404040 Rolighedsvej 3";
       String actual = instance.editUser();
        assertEquals(expected, actual);
    }*/
}