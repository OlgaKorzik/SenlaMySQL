package eu.senla;

import eu.senla.utils.DaoTable;
import eu.senla.utils.User;
import org.junit.jupiter.api.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import java.sql.ResultSet;
import java.sql.SQLException;

import static eu.senla.utils.DataForTest.*;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(JUnitPlatform.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JDBCTest extends BaseClass{

    @Test
    @Order(1)
    @DisplayName("Check to create new table")
    public void createTableTest(){
        DaoTable.createTable(CREATE_NEW_TABLE);
    }
    @Test
    @Order(2)
    @DisplayName("Check to adding into table")
    public void insertIntoTableTest(){
        User user = new User(20,"Ivan","Ivanov","Toronto");
        DaoTable.insertIntoTable(user, INSERT_DATA_FROM_TABLE);
        ResultSet rs = DaoTable.selectFromeTable(SELECT_ALL_DATA);
        assertAll("Should return inserted data",
                ()->assertEquals("20", rs.getString("id")),
                ()->assertEquals("Ivan",rs.getString("first_name")),
                ()->assertEquals("Ivanov",rs.getString("last_name")),
                ()->assertEquals("Toronto",rs.getString("town")));
    }
    @Test
    @Order(3)
    @DisplayName("Check to select from first_name")
    public void selectTest(){
        ResultSet rs = DaoTable.selectFromeTable(SELECT_FIRST_NAME);
        assertAll("Should return inserted data",
                ()->assertEquals("20", rs.getString("id")),
                ()->assertEquals("Ivan",rs.getString("first_name")),
                ()->assertEquals("Ivanov",rs.getString("last_name")),
                ()->assertEquals("Toronto",rs.getString("town")));
    }
    @Test
    @Order(4)
    @DisplayName("Check to update table")
    public void updateTableTest() throws SQLException {
        DaoTable.updateInTable("Gogol",UPDATE_LAST_NAME);
        ResultSet rs = DaoTable.selectFromeTable(SELECT_ALL_DATA);
        String actualLastName = rs.getString("last_name");
        assertTrue("Gogol".contains(actualLastName));
    }

    @Test
    @Order(5)
    @DisplayName("Check to select join")
    public void selectJoinTest() throws SQLException {
        ResultSet rs = DaoTable.selectFromeTable(SELECT_JOIN_COUNTRY);
        String expectedCountry = "Canada";
        String actualCountry = rs.getString("country");
        assertEquals(expectedCountry,actualCountry, "Don't select");

    }
    @Test
    @Order(6)
    @DisplayName("Check to deleting data from a table")
    public void deleteDataFromTableTest(){
        DaoTable.deleteFromTable("20",DELETE_FROM_ID);
    }

    @Test
    @Order(7)
    @DisplayName("Check to delete table")
    public void deleteTableTest(){
        DaoTable.deleteTable(DELETE_TABLE);

    }

}
