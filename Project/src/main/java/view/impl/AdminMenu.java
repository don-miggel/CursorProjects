package view.impl;

import model.Admin;
import model.User;
import model.UserManager;
import service.MenuOperation;
import view.Menu;

import java.util.Scanner;

public class AdminMenu implements Menu {

     Admin loggedInAdmin = null;

     AdminMenu(Admin loggedInAdmin){
         this.loggedInAdmin = loggedInAdmin;
     }

     public  void  show() {
        System.out.println("1. Users Menu");
        System.out.println("2. Orders Menu");
        System.out.println("3. Products menu");
        System.out.println("4. Exit");
        System.out.println("5. Logout");
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        switch (userChoice){
            case 1:
                performUserOperations();
                break;
            case 2:
                new OrdersMenu(this, (Admin)loggedInAdmin).show();
                break;
            case 3:
                performProductsOperations();
                show();
                break;
            case 4:
                exit();
                break;
            case 5:
                loggedInAdmin.logout();
                new LoginMenu().show();
            default:
                System.out.println("Invalid operation chosen");
                show();
        }
    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }

    private void performUserOperations(){
        Scanner sc = new Scanner(System.in);
        int userIdChoice = 0;
        System.out.println("Choose an operation:");
        System.out.println("1. Lock user");
        System.out.println("2. Unlock user");
        System.out.println("3. Return to Admin menu");
        System.out.println("4. Exit");
        int operationChoice = sc.nextInt();
        switch (operationChoice){
            case 1:
            case 2:
                UserManager.displayAllUsers();
                System.out.println("Choose a user for this operation"+ operationChoice);
                int userChoice = sc.nextInt();
                if(operationChoice == 1) {
                    if (((Admin)loggedInAdmin).lockUser(userChoice))
                        System.out.println("You have successfully locked a user with Id: " + userChoice);
               }
                if (operationChoice == 2) {
                    if (((Admin)loggedInAdmin).unlockUser(userChoice))
                        System.out.println("You have successfully unlocked a user with Id: " + userChoice);
                }
                performUserOperations();
                break;
            case 3:
                show();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Wrong menu item");
                show();
                }
        }

        private void performOrdersOperations(){
            new OrdersMenu(this, (Admin)loggedInAdmin).show();
        }

        private void performProductsOperations(){
            new ProductChangeMenu(this, loggedInAdmin).show();
        }
}

