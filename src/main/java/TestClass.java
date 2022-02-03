import DBConnector.DBConector;
import Mapper2.Facade;

public class TestClass {
    String newName;
    String newLastName;
    String newPW;
    String newPhone;
    String newAddress;


    public Facade changeDB() throws ClassNotFoundException {
        Facade t = new Facade();
        t.editUser("Chris", "Hold", "Tophemmlig", "opppevej 2", "30303030");
        return t;
    }
}
