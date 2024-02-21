import CRUD.UserCrudOperation;

public class Main {
    public static void main(String[] args) {
        UserCrudOperation userCrudOperation = new UserCrudOperation();

        // Create a user
        /*Integer rows = userCrudOperation.createUser();

        if(rows != 0){
            System.out.println("User Added Successfully !!!");
        }

        else{
            System.out.println("User Cannot be added ...... , try again later");
        }*/

        userCrudOperation.getAllUsers();
    }
}