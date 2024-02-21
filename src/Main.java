import CRUD.DeleteUser;
import CRUD.UpdateUser;
import CRUD.UserCrudOperation;

public class Main {
    public static void main(String[] args) {
        UserCrudOperation userCrudOperation = new UserCrudOperation();
//        UpdateUser updateUser = new UpdateUser();
//        DeleteUser deleteUser = new DeleteUser();

        // Create a user
        /*Integer rows = userCrudOperation.createUser();

        if(rows != 0){
            System.out.println("User Added Successfully !!!");
        }

        else{
            System.out.println("User Cannot be added ...... , try again later");
        }*/

        // Fetch all users
        userCrudOperation.getAllUsers();

        // Update a user
        /*Integer rowsupdated = updateUser.update();

        if(rowsupdated != 0){
            System.out.println("User Updated Successfully !!!");
        }

        else{
            System.out.println("User Cannot be updated ...... , try again later");
        }*/

        // Delete a user with userId
        /*Integer rowsupdated = deleteUser.delete();

        if(rowsupdated != 0){
            System.out.println("User Deleted Successfully !!!");
        }

        else{
            System.out.println("User Cannot be deleted ...... , try again later");
        }*/
    }
}