package eu.senla;

import eu.senla.utils.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static eu.senla.utils.DataConnection.*;


public class MyConnections {
    public static Connection con = null;


    public static Connection connect(){
        Log.info("Connect to DB " + URL + " by user " + USERNAME);
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Log.info("Connection to DB successful!");
        } catch (ClassNotFoundException | SQLException e) {
            Log.error(e.getMessage());
        }  return con;
    }

    public static void disconnect(){
        if(con != null){
            try {
                con.close();
                Log.info("Connection to DB closed successfully");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
