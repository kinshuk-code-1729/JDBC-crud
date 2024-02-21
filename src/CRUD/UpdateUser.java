package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateUser {
    public Integer update(){
        // find username and update fullName & passwd
        Connection con = null;
        Integer rowUpdated = 0;
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter user's UserName which you wanna update : ");
            String uname = sc.nextLine();

            System.out.print("Enter new Name : ");
            String name = sc.nextLine();

            System.out.print("Enter new Email : ");
            String email = sc.nextLine();

            con = Configuration.createConnection();

            String updateQuery = "UPDATE users SET fullname = ?, email = ? where username = ?";
            PreparedStatement st = con.prepareStatement(updateQuery);

            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, uname);

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
