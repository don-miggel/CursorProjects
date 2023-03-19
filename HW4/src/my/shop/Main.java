package my.shop;

import my.shop.customers.Customer;
import my.shop.enums.ClientRestrictionStatus;
import my.shop.exceptions.BuyingNotEligibleException;
import my.shop.exceptions.NotEnoughMoneyException;
import my.shop.exceptions.OutOfStockException;
import my.shop.exceptions.ProductExpiredException;
import my.shop.products.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws OutOfStockException, NotEnoughMoneyException, ProductExpiredException, BuyingNotEligibleException {

        // let's create some different types of products, both Food and Electronics nad a client

        FoodProduct tuna = new FoodProduct("Tuna can", 3.0, 31, ClientRestrictionStatus.NONE, 2023, 4, 2);
        FoodProduct salmon = new FoodProduct("Salmon can", 5.2, 2, ClientRestrictionStatus.NONE, 2023, 5, 17);
        FoodProduct beans = new FoodProduct("Beans can", 2.3, 2, ClientRestrictionStatus.NONE, 2023, 3, 17);
        System.out.println(tuna.getName() + " ( less than or equal to 15 days expiration) price is: " + tuna.getPrice());
        System.out.println(salmon.getName() + "  price is: " + salmon.getPrice());

        ElectonicsProduct macMini = new Computer("Apple mac mini M2", 699.0, 1005, ClientRestrictionStatus.TEENAGER);
        System.out.println(macMini);
        System.out.println(macMini.getName() + " price is " + macMini.getPrice() + " for products more 1000 units (95% of price)");
        Customer dan = new Customer("Dan", 19, 20.25);
        System.out.println(dan);

        FoodProduct cognac = new FoodProduct("Hennessy cognac", 71.23, 19, ClientRestrictionStatus.ADULT, 2023, 7, 31);
        ElectonicsProduct refr = new Appliance("Refrigerator LG", 499.0, 50, ClientRestrictionStatus.ADULT);
        System.out.println(macMini.getName() + " price is " + macMini.getPrice());
        System.out.println(refr.getName() + " price is " + refr.getPrice());

        FoodProduct cigar = new FoodProduct("Cuban cigar", 20.26, 19, ClientRestrictionStatus.ADULT, 2023, 4, 19);
        System.out.println(cigar);
        // check NotEnoughMoneyException, when a client has a lack of money
        System.out.println("---------------------------------------------------------------");
        System.out.println("-------------Check NotEnoughMoneyException-------------------");
        System.out.println("Dan balance before purchase: " + dan.getBalance());
        System.out.println("Cigar qty before purchase: " + cigar.getQuantity());
        PurchaseManager.makePurchase(cigar, dan);
        System.out.println("Dan balance after purchase: " + dan.getBalance());
        System.out.println("Cigar qty after purchase: " + cigar.getQuantity());

        //try case when a client has enough money
        System.out.println("---------------------------------------------------------------");
        System.out.println("------Now check buy function when a client has enough money and is eligible to buy such a product-----------");
        System.out.println(dan.getName() + "'s balance before purchase: " + dan.getBalance());
        System.out.println(cigar.getName() + " qty before purchase: " + cigar.getQuantity());
        cigar.setPrice(19.16);
        PurchaseManager.makePurchase(cigar, dan);
        System.out.println("Dan balance after purchase: " + dan.getBalance());
        System.out.println("Cigar qty after purchase: " + cigar.getQuantity());

        //let's try to set an age below 18 and to buy a cognac
        System.out.println("---------------------------------------------------------------");
        System.out.println("----------------Check BuyingNotEligibleException---------------");
        dan.setAge(17);
        dan.setBalance(100.25);
        System.out.println(dan.getName() + "'s balance before purchase: " + dan.getBalance());
        System.out.println(cognac.getName() + " qty before purchase: " + cognac.getQuantity());
        PurchaseManager.makePurchase(cognac, dan);
        System.out.println(dan.getName() + "'s balance after purchase: " + dan.getBalance());
        System.out.println(cognac.getName() + " qty after purchase: " + cognac.getQuantity());

        // let's check OutOfStockException
        System.out.println("---------------------------------------------------------------");
        System.out.println("----------------Check OutOfStockException--------------------");
        dan.setAge(22);
        refr.setQuantity(0);
        System.out.println(dan.getName() + "'s balance before purchase: " + dan.getBalance());
        System.out.println(refr.getName() + " qty before purchase: " + refr.getQuantity());
        PurchaseManager.makePurchase(refr, dan);
        System.out.println(dan.getName() + "'s balance after purchase: " + dan.getBalance());
        System.out.println(refr.getName() + " qty after purchase: " + refr.getQuantity());

        // let's check ProductExpiredException
        System.out.println("---------------------------------------------------------------");
        System.out.println("-----------Check ProductExpiredException------------------");
        tuna.setExpDate(2023, 3, 15);
        System.out.println(dan.getName() + "'s balance before purchase: " + dan.getBalance());
        System.out.println(tuna.getName() + " qty before purchase: " + tuna.getQuantity());
        PurchaseManager.makePurchase(tuna, dan);
        System.out.println(dan.getName() + "'s balance after purchase: " + dan.getBalance());
        System.out.println(tuna.getName() + " qty after purchase: " + tuna.getQuantity());

        // create a list of different products
        List<Product> lstPrd = new ArrayList<>();
        lstPrd.add(macMini);
        lstPrd.add(cigar);
        lstPrd.add(tuna);
        lstPrd.add(salmon);
        lstPrd.add(cognac);
        lstPrd.add(refr);
        lstPrd.add(beans);

        // search products by parameters: expired products and products which can be bought by only adults
        System.out.println("---------------------------------------------------------------");
        System.out.println("---------Expired products-------------");
        PurchaseManager.filterProducts(lstPrd, "expired");
        System.out.println("---------Products which can be bought by adults-------------");
        PurchaseManager.filterProducts(lstPrd, "adult");

    }
}
