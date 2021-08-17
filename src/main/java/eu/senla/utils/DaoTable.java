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
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void insertIntoTable(User user, String str){
        try {
            pstmt = MyConnections.connect().prepareStatement(str);
            pstmt.setInt(1,user.getId());
            pstmt.setString(2, user.getFirst_name());
            pstmt.setString(3, user.getLast_name());
            pstmt.setString(4, user.getTown());
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void updateInTable(String value, User newUser, String str){
        try {
            pstmt =MyConnections.connect().prepareStatement(str);
            pstmt.setInt(1,newUser.getId());
            pstmt.setString(2, newUser.getFirst_name());
            pstmt.setString(3, newUser.getLast_name());
            pstmt.setString(4, newUser.getTown());
            pstmt.setString(5, value);
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static ResultSet selectFromeTable(String str){
        try {
            stmt = MyConnections.connect()
                    .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(str);
            rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }
    public static void deleteFromTable(String value, String str){
        try {
            pstmt = MyConnections.connect().prepareStatement(str);
            pstmt.setString(1,value);
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void deleteTable(String str){
        try {
            pstmt = MyConnections.connect().prepareStatement(str);
            pstmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }



}
