package my.shop.exceptions;

import my.shop.customers.Customer;
import my.shop.products.Product;

public class BuyingNotEligibleException extends Exception {

    public BuyingNotEligibleException(Customer cst, Product prd) {
        super(cst.getName() + " is not eligible to buy a " + prd.getName() + ".You are younger than 18 years! ");
    }
}
