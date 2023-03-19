package my.shop.products;

import my.shop.customers.Customer;
import my.shop.enums.ClientRestrictionStatus;
import my.shop.exceptions.BuyingNotEligibleException;
import my.shop.exceptions.NotEnoughMoneyException;
import my.shop.exceptions.OutOfStockException;
import my.shop.exceptions.ProductExpiredException;

import java.time.LocalDate;
import java.util.List;

public class PurchaseManager {

    public static void processPurchase(Product product, Customer customer) throws BuyingNotEligibleException,
            OutOfStockException, ProductExpiredException, NotEnoughMoneyException {

        if (product.ageRestriction == ClientRestrictionStatus.ADULT && customer.getAge() < 18) {
            throw new BuyingNotEligibleException(customer, product);
        }
        if (product.getQuantity() < 1) {
            throw new OutOfStockException(product);
        }
        if (product instanceof FoodProduct && ((FoodProduct) product).getExpirationDate().compareTo(LocalDate.now()) <= 0) {
            throw new ProductExpiredException(product);
        }
        if (customer.getBalance() < product.getPrice()) {
            throw new NotEnoughMoneyException(customer, product);
        }
        customer.reduceBalance(product.getPrice());
        product.reduceQty(1);
    }

    public static void filterProducts(List<Product> lstPrd, String param) {

        for (Product prd : lstPrd) {
            if ("expired".equals(param) && prd instanceof FoodProduct && ((FoodProduct) prd).getExpirationDate().compareTo(LocalDate.now()) <= 0) {
                System.out.println(prd);
            }
            if ("adult".contentEquals(param) && prd.getAgeRestriction() == ClientRestrictionStatus.ADULT) {
                System.out.println(prd);
            }
        }

    }

    public static void makePurchase(Product prd, Customer cst) {
        try {
            PurchaseManager.processPurchase(prd, cst);
        } catch (BuyingNotEligibleException | ProductExpiredException | OutOfStockException |
                 NotEnoughMoneyException exc) {
            System.out.println(exc);

        }
    }
}
