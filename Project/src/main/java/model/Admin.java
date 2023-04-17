package model;

import service.UserLock;

import java.util.Scanner;

public class Admin extends User implements UserLock {

    Admin(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password, UserRole.ADMIN);
    }

    @Override
    public boolean lockUser(int userId) {
        return UserManager.lockUser(this, userId);
        /*
        if (!(UserManager.checkUserPresence(this) && UserManager.checkUserPresence(userToLock))) return;

        if (getRole() == UserRole.ADMIN &&
                (userToLock.getStatus() != UserStatus.BLOCKED ||
                        userToLock.getStatus() != UserStatus.DELETED)){
            userToLock.setStatus(UserStatus.BLOCKED);
        }

         */
    }

    @Override
    public boolean unlockUser(int userId) {
        return UserManager.unlockUser(this, userId);
        /*
        if (!(UserManager.checkUserPresence(this) && UserManager.checkUserPresence(whomToUnlock))) return;

        if (getRole() == UserRole.ADMIN &&
                (whomToUnlock.getStatus() != UserStatus.ACTIVE ||
                        whomToUnlock.getStatus() != UserStatus.DELETED)){
            whomToUnlock.setStatus(UserStatus.ACTIVE);
        }

         */
    }

    public void confirmOrder(int orderId) {
        Order orderToConfirm = OrderManagement.getOrder(orderId);
        if (orderToConfirm == null) {
            System.out.println("Order with Id: " + orderId + " does not exist!");
            return;
        }
        if (orderToConfirm.getStatus().equals(OrderStatus.CREATED)) {
            orderToConfirm.changeStatus(OrderStatus.CONFIRMED);
            System.out.println("Status for order with ID:" + orderToConfirm.getOrderId() + " is changed to: "
                    + orderToConfirm.getStatus());
        }
    }

    public void unconfirmOrder(int orderId) {
        Order orderToConfirm = OrderManagement.getOrder(orderId);
        if (orderToConfirm == null) {
            System.out.println("Order with Id: " + orderId + " does not exist!");
            return;
        }
        if (orderToConfirm.getStatus().equals(OrderStatus.CONFIRMED)) {
            orderToConfirm.changeStatus(OrderStatus.DECLINED);
            System.out.println("Status for order with ID:" + orderToConfirm.getOrderId() + " is changed to: "
                    + orderToConfirm.getStatus());
        }
    }

    public boolean addNewProduct() {
        Scanner scText = new Scanner(System.in);
        Scanner scNumbers = new Scanner(System.in);
        System.out.println("Enter product name:");
        String prodName = scText.nextLine();
        System.out.println("Enter product brand");
        String prodBrand = scText.nextLine();
        System.out.println("Enter product category:");
        String prodCat = scText.nextLine();
        System.out.println("Enter product price:");
        double price = scNumbers.nextDouble();
        System.out.println("Enter product quantity available:");
        int qty = scNumbers.nextInt();
        Product newProd = new Product(prodBrand, prodCat, prodName, price, qty);
        return ProductWarehouse.addProduct(newProd);
    }
}
