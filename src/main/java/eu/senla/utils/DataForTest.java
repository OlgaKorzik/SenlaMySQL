package eu.senla.utils;

public final class DataForTest {
    public static String TABLE_NAME = "user";
    public static String CREATE_NEW_TABLE = "CREATE TABLE "+ TABLE_NAME +"("
            + "id int(6) NOT NULL,"
            + "first_name VARCHAR(45) NOT NULL,"
            + "last_name VARCHAR(45) NOT NULL,"
            + "town VARCHAR(45) NOT NULL,"
            + "PRIMARY KEY (id))";
    public static String SELECT_ALL_DATA = "SELECT * FROM " + TABLE_NAME;
    public static String INSERT_DATA_FROM_TABLE = "INSERT INTO "+ TABLE_NAME +"("
            +"id, first_name, last_name, town)"
            +" VALUES(?,?,?,?)";
    public static String SELECT_FIRST_NAME ="SELECT * FROM "+ TABLE_NAME
            +" WHERE first_name = \"Ivan\"";
    public static String SELECT_FROM_ID= "SELECT * FROM "+ TABLE_NAME
            + "WHERE id = ";
    public static String UPDATE_LAST_NAME ="UPDATE "+ TABLE_NAME +" SET last_name=?"
            +" WHERE first_name =  \"Ivan\"";
    public static String SELECT_JOIN_COUNTRY = "SELECT u.town, cntr.country\n"
    +"FROM user u LEFT JOIN country cntr ON u.id=cntr.country_id WHERE town ='Toronto'";
    public static String DELETE_FROM_ID = "DELETE FROM "+ TABLE_NAME +" WHERE id=?";
    public static String DELETE_TABLE ="DROP TABLE "+ TABLE_NAME;

}
