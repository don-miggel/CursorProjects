package model;

import java.util.ArrayList;
import java.util.Objects;

public class ProductWarehouse {

    private static ArrayList<Product> warehouse;

    static {
        warehouse = new ArrayList<>();
    }

    public static boolean addProduct(Product product) {
        if (!warehouse.contains(product)) {
            warehouse.add(product);
            System.out.println(product + " has been added to the warehouse! ");
            return true;
        }
        return false;
    }

    public static void prepopulateProducts() {
        warehouse.add(new Product("Genius", "Mouses", "mouse", 23, 22));
        warehouse.add(new Product("Kenwood", "Audio", "loudspeakers", 135, 7));
        warehouse.add(new Product("Apple", "Phones", "iPhone SE", 399, 15));
        warehouse.add(new Product("Samsung", "Phones", "Galaxy phone", 499, 11));
        warehouse.add(new Product("LG", "Fridges", "Inverter fridge GW-B509SLKM", 799, 17));
        warehouse.add(new Product("Philips", "House Cleaning", "Vacuum cleaner 9000 series", 415, 8));
        warehouse.add(new Product("LG", "Monitors", "27 inch LG UltraFine 27UL500-W", 325, 5));
        warehouse.add(new Product("Dell", "Monitors", "27 inch Dell P2722H", 297, 12));
        warehouse.add(new Product("Dell", "Keyboards", "keyboard Multimedia KB-216 USB", 25, 22));
        warehouse.add(new Product("Dell", "Keyboards", "keyboard Pro Wireless Keyboard and Mouse", 125, 9));
    }

    public static boolean removeProduct(Product product) {
        if (warehouse.contains(product)) {
            warehouse.remove(product);
            return true;
        }
        return false;
    }

    public static boolean removeProduct(String name) {
        Product prodToRemove = getProduct(name);
        return removeProduct(prodToRemove);
    }

    public static boolean removeProduct(int id) {
        Product prodToRemove = getProductById(id);
        return removeProduct(prodToRemove);
    }

    public static Product getProduct(String name) {
        for (Product prd : warehouse) {
            if (Objects.equals(prd.getProdName(), name))
                return prd;
        }
        return null;
    }

    private static boolean inputCheck(String input) {
        return input != null && input.length() > 1;
    }

    public static void searchByName(String name) {
        if (!inputCheck(name)) {
            System.out.println("Your input should contain at least 2 characters");
            return;
        }
        ArrayList<Product> foundProds = new ArrayList<>();
        for (Product prd : warehouse) {
            if (prd.getProdName().toLowerCase().contains(name.toLowerCase()))
                foundProds.add(prd);
        }
        displayAllProds(foundProds);
    }

    public static Product getProductById(int id) {
        for (Product prd : warehouse) {
            if (Objects.equals(prd.getProdId(), id))
                return prd;
        }
        return null;
    }

    public static void searchByBrand(String brandName) {
        if (!inputCheck(brandName)) {
            System.out.println("Your input should contain at least 2 characters");
            return;
        }
        ArrayList<Product> foundProds = new ArrayList<>();
        for (Product prd : warehouse) {
            if (prd.getBrand().toLowerCase().contains(brandName.toLowerCase()))
                foundProds.add(prd);
        }
        displayAllProds(foundProds);
    }

    public static void searchByCategory(String category) {
        if (!inputCheck(category)) {
            System.out.println("Your input should contain at least 2 characters");
            return;
        }
        ArrayList<Product> foundProds = new ArrayList<>();
        for (Product prd : warehouse) {
            if (prd.getCategory().toLowerCase().contains(category.toLowerCase()))
                foundProds.add(prd);
        }
        displayAllProds(foundProds);
    }

    public static void searchProdsInPriceRange(double startPrice, double endPrice) {
        ArrayList<Product> foundProds = new ArrayList<>();
        for (Product prd : warehouse) {
            if (prd.getProdPrice() >= startPrice && prd.getProdPrice() <= endPrice) {
                foundProds.add(prd);
            }
        }
        displayAllProds(foundProds);

    }

    public static boolean buyProduct(User usr, Product prd) {
        if (usr.getStatus() == UserStatus.ACTIVE) {

        }
        return false;
    }

    public static ArrayList<Product> getAllProducts() {
        return warehouse;
    }

    public static int getProductsQty() {
        return warehouse.size();
    }

    public static void displayAllProds(ArrayList<Product> prods) {
        if (prods == null || prods.size() == 0) {
            System.out.println("There is no products to display");
            return;
        }
        for (Product prd : prods) {
            displayProduct(prd);
        }
    }

    public static void displayAllProds() {
        for (Product prd : warehouse) {
            displayProduct(prd);
        }
    }

    private static void displayProduct(Product prd) {
        System.out.println("Product Id: " + prd.getProdId() + ", brand: " + prd.getBrand() + ", category: "
                + prd.getCategory() + ", name: " + prd.getProdName() +
                ", price: " + prd.getProdPrice() + " $, qty: " + prd.getProdQty());
    }

}
