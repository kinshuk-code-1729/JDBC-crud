package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreateUser {
    public Integer create(){
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
}
