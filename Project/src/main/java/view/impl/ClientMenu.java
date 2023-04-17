package view.impl;

import model.*;
import view.Menu;

import java.util.Scanner;


public class ClientMenu implements Menu {

    User loggedInClient = null;

    ClientMenu(User loggedInClient) {
        this.loggedInClient = loggedInClient;
    }

    public void show() {
        Scanner sc = new Scanner(System.in);
        int userIdChoice = 0;
        System.out.println("Choose an operation:");
        System.out.println("1. Show my data");
        System.out.println("2. Available products");
        System.out.println("3. Product search");
        System.out.println("4. My orders");
        System.out.println("5. Logout");
        int operationChoice = sc.nextInt();
        switch (operationChoice) {
            case 1:
                System.out.println(loggedInClient);
                show();
                break;
            case 2:
                ProductWarehouse.displayAllProds();
                System.out.println("Do you want to place an order or return to a client menu? " +
                        "1- place an order, any other digit - return to a client menu");
                int orderChoice = sc.nextInt();
                if (orderChoice == 1) {
                    Order newOrder = ((Client) loggedInClient).createUserOrder();
                    OrderManagement.displayOrderDetails(newOrder);
                    show();
                } else
                    show();
                break;
            case 3:
                new ProductSearchMenu(this).show();
                break;
            case 4:
                OrderManagement.getOrdersByUser(loggedInClient);
                show();
                break;
            case 5:
                loggedInClient.logout();
                exit();
                break;
            default:
                System.out.println("Wrong menu item");
                show();
        }
    }

    @Override
    public void exit() {
        new LoginMenu().show();
    }

}
