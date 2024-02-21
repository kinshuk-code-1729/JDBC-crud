package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUser {
    public Integer delete() {
        // find username and delete the user
        Connection con = null;
        Integer rowUpdated = 0;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter user's UserName which you wanna delete : ");
            String uname = sc.nextLine();

            con = Configuration.createConnection();
            String deleteQuery = "DELETE FROM users where username = ?";
            PreparedStatement st = con.prepareStatement(deleteQuery);

            st.setString(1, uname);

            rowUpdated = st.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return rowUpdated;
    }
}