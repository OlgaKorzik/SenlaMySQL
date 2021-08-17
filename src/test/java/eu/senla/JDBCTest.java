package eu.senla;

import eu.senla.utils.DaoTable;
import eu.senla.utils.User;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;


//@RunWith(JUnitPlatform.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JDBCTest extends BaseClass{

    @Test
    @Order(1)
    @DisplayName("Check to create new table")
    public void createTableTest(){
        String str = "CREATE TABLE user ("
                + "id int(6) NOT NULL,"
                + "first_name VARCHAR(45) NOT NULL,"
                + "last_name VARCHAR(45) NOT NULL,"
                + "town VARCHAR(45) NOT NULL,"
                + "PRIMARY KEY (id))";
        DaoTable.createTable(str);
    }
    @Test
    @Order(2)
    @DisplayName("Check to adding into table")
    public void insertIntoTableTest(){
        User user = new User(1,"Ivan","Ivanov","London");
        String str = "INSERT INTO user (id, first_name, last_name, town) VALUES(?,?,?,?)";
        DaoTable.insertIntoTable(user,str);
        String st = "SELECT * FROM user";
        ResultSet rs = DaoTable.selectFromeTable(st);
        assertAll("Should return inserted data",
                ()->assertEquals("1", rs.getString("id")),
                ()->assertEquals("Ivan",rs.getString("first_name")),
                ()->assertEquals("Ivanov",rs.getString("last_name")),
                ()->assertEquals("London",rs.getString("town")));
    }
    @Test
    @Order(3)
    @DisplayName("Check select")
    public void selectTest(){
        String str ="SELECT * FROM user WHERE first_name = \"Ivan\"";
        ResultSet rs = DaoTable.selectFromeTable(str);
        assertAll("Should return inserted data",
                ()->assertEquals("1", rs.getString("id")),
                ()->assertEquals("Ivan",rs.getString("first_name")),
                ()->assertEquals("Ivanov",rs.getString("last_name")),
                ()->assertEquals("London",rs.getString("town")));
    }
    @Test
    @Order(4)
    public void deleteTableTest(){
        String str ="DROP TABLE user";
        DaoTable.deleteTable(str);

    }

}
