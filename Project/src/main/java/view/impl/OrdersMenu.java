package view.impl;

import model.Admin;
import model.OrderManagement;
import view.Menu;

import java.util.Scanner;

public class OrdersMenu implements Menu {

    AdminMenu admMenu = null;
    Admin adm = null;

    OrdersMenu(AdminMenu admMenu, Admin adm){
        this.admMenu = admMenu;
        this.adm = adm;
    }
    @Override
    public void show() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Display all orders");
        System.out.println("2. Confirm order");
        System.out.println("3. Unconfirm order");
        System.out.println("4. Return to Admin menu");
        int admChoice = sc.nextInt();
        int orderId = 0;
        switch (admChoice){

            case 1:
                OrderManagement.displayOrders();
                show();
                break;
            case 2:
                System.out.println("Enter order Id to confirm:");
                orderId = sc.nextInt();
                adm.confirmOrder(orderId);
                show();
                break;
            case 3:
                System.out.println("Enter order Id to unconfirm:");
                orderId = sc.nextInt();
                adm.unconfirmOrder(orderId);
                show();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Please, choose a correct item!");
                show();
        }
    }

    @Override
    public void exit() {
        admMenu.show();
    }
}
