package CRUD;

import java.sql.*;

public class Configuration {
    private final static String URL = "jdbc:mysql://localhost:3306/foodiedb";
    private final static String userName = "root";
    private final static String password = "";
    public static Connection createConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,userName,password);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}
