package my.shop.exceptions;

import my.shop.products.Product;

public class OutOfStockException extends Exception {

    public OutOfStockException(Product product) {
        super(product.getName() + " is Out of stock");
    }
}
