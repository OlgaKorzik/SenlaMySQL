package eu.senla.utils;

import eu.senla.MyConnections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoTable {
    private static PreparedStatement pstmt = null;
    private static ResultSet rs =null;
    private static Statement stmt = null;


    public static void createTable(String str){
        try {
            pstmt = MyConnections.connect().prepareStatement(str);
            Log.info("Send request to DB: " + str);
            pstmt.execute();
            Log.info("Create table to DB successful");
        } catch (SQLException throwables) {
            Log.error(throwables.getMessage());
        }
    }
    public static void insertIntoTable(User user, String str){
        try {
            pstmt = MyConnections.connect().prepareStatement(str);
            Log.info("Send request to DB: " + str);
            pstmt.setInt(1,user.getId());
            pstmt.setString(2, user.getFirst_name());
            pstmt.setString(3, user.getLast_name());
            pstmt.setString(4, user.getTown());
            pstmt.execute();
            Log.info("Data insert from table successful");
        } catch (SQLException throwables) {
            Log.error(throwables.getMessage());
        }

    }

    public static void updateInTable(String value, String str){
        try {
            pstmt =MyConnections.connect().prepareStatement(str);
            Log.info("Send request to DB: " + str);
            pstmt.setString(1, value);
            pstmt.execute();
            Log.info("Update data from table successful");
        } catch (SQLException throwables) {
            Log.error(throwables.getMessage());
        }
    }
    public static ResultSet selectFromeTable(String str){
        try {
            stmt = MyConnections.connect()
                    .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(str);
            rs.next();
        } catch (SQLException throwables) {
            Log.error(throwables.getMessage());
        }
        return rs;
    }
    public static void deleteFromTable(String value, String str){
        try {
            pstmt = MyConnections.connect().prepareStatement(str);
            Log.info("Send request to DB: " + str);
            pstmt.setString(1,value);
            pstmt.execute();
            Log.info("Delete data from table successful");
        } catch (SQLException throwables) {
            Log.error(throwables.getMessage());
        }

    }
    public static void deleteTable(String str){
        try {
            pstmt = MyConnections.connect().prepareStatement(str);
            Log.info("Send request to DB: " + str);
            pstmt.execute();
            Log.info("Delete table to DB successful");
        } catch (SQLException throwables) {
            Log.error(throwables.getMessage());
        }

    }



}
