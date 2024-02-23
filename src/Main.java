import CRUD.DeleteUser;
import CRUD.GetAllUsers;
import CRUD.UpdateUser;
import CRUD.CreateUser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        CreateUser createUser = new CreateUser();
        GetAllUsers getAllUsers = new GetAllUsers();
        UpdateUser updateUser = new UpdateUser();
        DeleteUser deleteUser = new DeleteUser();

        while(true) {
            System.out.println("-----------------------------");
            System.out.println("******CRUD Operations********");
            System.out.println("1. Add a new user");
            System.out.println("2. Fetch all users");
            System.out.println("3. Modify any user");
            System.out.println("4. Remove any user");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            // Create a user
            if (choice == 1) {
                Integer rows = createUser.create();

                if (rows != 0) {
                    System.out.println("User Added Successfully !!!");
                } else {
                    System.out.println("User Cannot be added ...... , try again later");
                }
            }

            // Fetch all users
            else if (choice == 2) {
                getAllUsers.getAll();
            }

            // Update a user
            else if (choice == 3) {
                Integer rowsupdated = updateUser.update();

                if (rowsupdated != 0) {
                    System.out.println("User Updated Successfully !!!");
                } else {
                    System.out.println("User Cannot be updated ...... , try again later");
                }
            }

            // Delete a user with userId
            else if (choice == 4) {
                Integer rowsdeleted = deleteUser.delete();

                if (rowsdeleted != 0) {
                    System.out.println("User Deleted Successfully !!!");
                } else {
                    System.out.println("User Cannot be deleted ...... , try again later");
                }
            }

            // exit loop condition
            else if(choice == 5){
                System.out.println("###<-- Thank you -->###");
                break;
            }
            // check for invalid condition
            else{
                System.out.println("Invalid Operation !!, Please try again !!!");
            }
        }
    }
}