package ge.tbc.testautomation.tests;

import ge.tbc.testautomation.data.DatabaseSteps;
import ge.tbc.testautomation.data.UserModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DBTests {
    DatabaseSteps dbSteps;
    @BeforeClass
    public void setUp(){
        dbSteps = new DatabaseSteps();
    }
    @Test
    public void testDB() {
//        int affectedRows = dbSteps.createUser();
//        System.out.println(affectedRows);
// CRUD
//        int affectedRows = dbSteps.updateUser();
//        System.out.println(affectedRows);

        int deletedRows = dbSteps.deleteUser();
        System.out.println(deletedRows);

        List<UserModel> users = dbSteps.selectAllUsers();
        System.out.println(users);
    }
}
