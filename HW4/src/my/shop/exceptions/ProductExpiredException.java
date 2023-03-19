package my.shop.exceptions;

import my.shop.products.FoodProduct;
import my.shop.products.Product;

public class ProductExpiredException extends Exception {

    public ProductExpiredException(Product fProduct) {
        super(fProduct.getName() + " has expiration date: " + ((FoodProduct) fProduct).getExpirationDate() + ", which is" +
                " less than current date");

    }
}
