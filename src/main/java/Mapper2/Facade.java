package Mapper2;


import DBConnector.DBConector;
import Mapper2.UserMapper;

public class Facade {

    UserMapper userMapper;

    DBConector db = new DBConector();

    public Facade() throws ClassNotFoundException {

        userMapper = new UserMapper(this.db);

    }

    public void editUser(String fname, String lname, String pw, String address, String phone) {
        User user = new User(fname,lname,pw,address, phone);
        userMapper.editUser(user);
    }

}
