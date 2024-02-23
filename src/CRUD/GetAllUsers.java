package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetAllUsers {
    public void getAll(){
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
