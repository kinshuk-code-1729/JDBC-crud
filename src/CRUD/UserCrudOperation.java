package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserCrudOperation {
    public Integer createUser(){
        Connection con = null;
        Integer rowUpdated = 0;
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter UserName : ");
            String uname = sc.nextLine();

            System.out.print("Enter your Password : ");
            String passwd = sc.nextLine();

            System.out.print("Enter Name : ");
            String name = sc.nextLine();

            System.out.print("Enter User Email : ");
            String email = sc.nextLine();

            con = Configuration.createConnection();

            String insertQuery = "INSERT INTO users (username, password, fullname, email) VALUES(?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(insertQuery);

            st.setString(1, uname);
            st.setString(2, passwd);
            st.setString(3, name);
            st.setString(4, email);

            rowUpdated = st.executeUpdate();

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return rowUpdated;
    }

    public void getAllUsers(){
        Connection con = null;
        Integer rowUpdated = 0;
        try{
            con = Configuration.createConnection();

            String AllUsersQuery = "SELECT * FROM users";
            PreparedStatement st = con.prepareStatement(AllUsersQuery);

            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long uid = rs.getLong(1);
                String uname = rs.getString(2);
                String pwd = rs.getString("password");
                String fname = rs.getString(4);
                String mail = rs.getString("email");

                String format = "User #%d: %s - %s - %s - %s";
                String outputFormat = String.format(format,uid, uname, pwd, fname, mail);
                System.out.println(outputFormat);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
