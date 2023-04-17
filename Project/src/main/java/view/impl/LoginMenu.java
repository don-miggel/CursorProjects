package view.impl;


import model.*;
import service.UserService;
import view.Menu;

import java.util.Scanner;

public class LoginMenu implements Menu {

    //    private UserService userService;
    private final String[] items = {"1.Login", "2.Register"};
    private Scanner sc;

    @Override
    public void show() {

        while (true)
            startMenu();

    }

    @Override
    public void exit() {
        System.exit(0);
    }

    private void loginSubMenu(Scanner scanner) {

        User loggedInUser = login();
        if (loggedInUser == null) {
            System.out.println("User with such an email is not found or password is incorrect. " +
                    "Do you want to register. 1- yes, 0 - no");
            int regChoice = sc.nextInt();
            if (regChoice == 1) {
                User newUser = registerClient();
                if (newUser != null)
                    System.out.println("User " + newUser.getUserFullName() + " has registered !");
                else {
                    System.out.println("Error occurred");
                    show();
                }

            } else
                show();
        } else {
            if (loggedInUser.getRole() == UserRole.ADMIN)
                new AdminMenu((Admin) loggedInUser).show();
            else
                new ClientMenu(loggedInUser).show();

        }
    }

    private void startMenu() {
        Scanner sc = new Scanner(System.in);
        User loggedInUser = null;
        System.out.println("1. Login user/admin");
        System.out.println("2. Register as user ");
        System.out.println("3. Exit");
        int userChoice = sc.nextInt();

        switch (userChoice) {
            case 1:
                loggedInUser = login();
                if (loggedInUser == null) {
                    System.out.println("User with such an email is not found or password is incorrect. " +
                            "Do you want to register. 1- yes, 0 - no");
                    int regChoice = sc.nextInt();
                    if (regChoice == 1) {
                        User newUser = registerClient();
                        if (newUser != null) {
                            System.out.println("User " + newUser.getUserFullName() + " has registered !");
                            startMenu();
                        } else {
                            System.out.println("Error occurred");
                            startMenu();
                        }

                    } else
                        startMenu();
                } else {
                    if (loggedInUser.getRole() == UserRole.ADMIN)
                        new AdminMenu((Admin) loggedInUser).show();
                    else
                        new ClientMenu(loggedInUser).show();
                }
                break;
            case 2:
                User newUser = registerClient();
                if (newUser != null) {
                    System.out.println("User " + newUser.getUserFullName() + " has registered !");
                    startMenu();
                } else {
                    System.out.println("Error occurred");
                    startMenu();
                }
            case 3:
                exit();
            default:
                System.out.println("Wrong menu item!");
                startMenu();

        }
    }

    private User login() {
        String userLogin, passwd = "";
        boolean isLoggedIn = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input user  email: ");
        userLogin = sc.nextLine();
        System.out.println("Input user password: ");
        passwd = sc.nextLine();
        User foundUser = UserManager.findUserByEmail(userLogin);

        if (foundUser != null) {
            isLoggedIn = foundUser.login(userLogin, passwd);
        }
        if (isLoggedIn) {
//                System.out.println("You have logged in as: " + foundUser.getUserFullName() + ", email: " + foundUser.getEmail());
            return foundUser;
        }
        return null;

    }

    private User registerClient() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Please, enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Please, enter your email: ");
        String email = sc.nextLine();
        System.out.println("Please, enter your password: ");
        String password = sc.nextLine();
        System.out.println("Please, enter your budget: ");
        double budget = sc.nextDouble();
        return UserManager.createClient(firstName, lastName, email, password, budget);
    }

    private void registerSubMenu(Scanner scanner) {
        show(); //todo add impl
    }
}

