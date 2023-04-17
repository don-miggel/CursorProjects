package model;

import service.OrderService;

import java.util.ArrayList;
import java.util.Scanner;

public class Client extends User implements OrderService {

    private ArrayList<Order> orders;
    private double budget;

    Client(String firstName, String lastName, String email, String password, double budget) {
        super(firstName, lastName, email, password, UserRole.CLIENT);
        this.budget = budget;
        orders = new ArrayList<>();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public double getCurrentBudget() {
        return budget;
    }

    public void decreaseBudget(double amount) {
        if (amount <= budget) {
            budget -= amount;
        }
    }

    public void increaseBudget(double amount) {
        budget += amount;
    }

    @Override
    public Order createUserOrder() {
        Scanner sc = new Scanner(System.in);
        int id, qty = 0, furtherBuyChoice;
        Order newOrder = new Order(this);
        boolean flag = true;
        double budgetBeforeWithdrawing = 0.0;
        int qtyBeforeDecreasing = 0;
        Product chosenProduct = null;
        double itemPrice = 0.0;
        while (flag) {
            System.out.println("Your current budget is: " + budget);
            ProductWarehouse.displayAllProds();
            System.out.println("Please enter product ID: ");
            id = sc.nextInt();
            System.out.println("Please enter product quantity to buy: ");
            qty = sc.nextInt();
            chosenProduct = ProductWarehouse.getProductById(id);
            if (chosenProduct == null) {
                System.out.println("Product with such Id does not exist. Still want to buy ? 1- yes, 0- no");
                furtherBuyChoice = sc.nextInt();
                if (furtherBuyChoice != 1) {
                    flag = false;
                }
                continue;
            }
            if (qty < 1) {
                System.out.println("Chosen quantity cannot be less than 1 !" + '\n' + "Still want to buy ? 1- yes, 0- no ");
                furtherBuyChoice = sc.nextInt();
                if (furtherBuyChoice != 1) {
                    flag = false;
                }
                continue;
            }
            if (chosenProduct.getProdQty() < 1) {
                System.out.println("Such a product is absent at the warehouse!" + '\n' + "Still want to buy ? 1- yes, 0- no ");
                furtherBuyChoice = sc.nextInt();
                if (furtherBuyChoice != 1) {
                    flag = false;
                }
                continue;
            }
            itemPrice = chosenProduct.getProdPrice() * qty;
            if (chosenProduct.getProdQty() < qty) {
                System.out.println("Your desired quantity exceed the product amount at the warehouse!" + '\n' + "Still want to buy ? 1- yes, 0- no ");
                furtherBuyChoice = sc.nextInt();
                if (furtherBuyChoice != 1) {
                    flag = false;
                }
                continue;

            }
            if (getCurrentBudget() < itemPrice) {
                System.out.println("You don't have enough money to add this item to the cart!" + '\n' + "Still want to buy ? 1- yes, 0- no ");
                furtherBuyChoice = sc.nextInt();
                if (furtherBuyChoice != 1) {
                    flag = false;
                }
                continue;
            }
            System.out.println("This item costs: " + itemPrice);

            qtyBeforeDecreasing = chosenProduct.getProdQty();

            budgetBeforeWithdrawing = getCurrentBudget();
            decreaseBudget(itemPrice);
            System.out.println("The budget rest is :" + getCurrentBudget());
            OrderManagement.increaseProdQtyIfPresent(newOrder, chosenProduct, qty);
            OrderManagement.changeProdQty(newOrder, chosenProduct, qty);

            System.out.println("Do you want to continue shopping? 1- yes, 0- no ");
            furtherBuyChoice = sc.nextInt();
            if (furtherBuyChoice != 1) {
                flag = false;
            }

        }

        if (qty == 0 || qtyBeforeDecreasing < qty || budgetBeforeWithdrawing < itemPrice) {
            return null;
        }
        OrderManagement.placeOrder(this, newOrder);

        return newOrder;
    }

    @Override
    public String toString() {
        return super.toString().replace('}', ' ') +
                ", budget= " + budget +
                ", order amount=" + OrderManagement.countOrdersByUser(this) +
                '}';
    }
}
