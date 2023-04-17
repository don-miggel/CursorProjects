package model;


import java.util.Objects;

public class Product {

    private static int prodAmount;

    private final int prodId;
    private String category;
    private String prodName;
    private String brand;
    private double prodPrice;
    private int prodQty;

    static {
        prodAmount = 0;
    }

    public Product(String brand, String category, String prodName, double prodPrice, int prodQty) throws IllegalArgumentException {
        if (prodName.length() < 1 || prodPrice <= 0 || prodQty < 0) throw new IllegalArgumentException();
        this.brand = brand;
        this.category = category;
        prodId = ++prodAmount;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQty = prodQty;
    }

    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public String getCategory() {
        return category;
    }

    public void changeCategory(String category) {
        this.category = category;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getProdQty() {
        return prodQty;
    }

    public static int getProdAmount() {
        return prodAmount;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProdQty(int prodQty) {
        this.prodQty = prodQty;
    }

    public void decreaseProdQTY(int prodQty) {
        if (prodQty > 0 && prodQty <= this.prodQty)
            this.prodQty -= prodQty;
        else
            System.out.println("Invalid qty !");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return product.getBrand().equals(brand) && prodName.equals(product.prodName) && category.equals(product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId);
    }

    @Override
    public String toString() {
        return
                "Product{ prodId='" + prodId + '\n' +
                        ", brand='" + brand + '\n' +
                        ", category;=" + category + '\n' +
                        ", prodName='" + prodName + '\n' +
                        ", prodPrice=" + prodPrice + '\n' +
                        ", prodQty: " + prodQty + '}';

    }
}
