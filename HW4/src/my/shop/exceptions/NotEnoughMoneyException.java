package my.shop.exceptions;

import my.shop.customers.Customer;
import my.shop.products.Product;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(Customer customer, Product prd) {
        super("You have current balance: " + customer.getBalance() + ", which is not enough to buy a " +
                prd.getName() + ", which costs: " + prd.getPrice());
    }

}
