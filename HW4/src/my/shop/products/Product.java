package my.shop.products;

import my.shop.enums.ClientRestrictionStatus;
import my.shop.interfaces.Buyable;

public abstract class Product implements Buyable {

    protected String name;
    protected double price;
    protected int quantity;
    protected ClientRestrictionStatus ageRestriction;

    Product(String name, double price, int quantity, ClientRestrictionStatus ageRestriction) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void reduceQty(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ClientRestrictionStatus getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(ClientRestrictionStatus ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Override
    public String toString() {
        return " name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", ageRestriction=" + ageRestriction
                + ',';
    }
}
