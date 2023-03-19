package my.shop.products;

import my.shop.enums.ClientRestrictionStatus;

public class Computer extends ElectonicsProduct {

    public Computer(String name, double price, int quantity, ClientRestrictionStatus ageRestriction) {
        super(name, price, quantity, ageRestriction, 24);
    }

    @Override
    public double getPrice() {
        return (quantity > 1000) ? price * 0.95 : price;
    }

    @Override
    public String toString() {
        return super.toString().replace("ElectonicsProduct", "Computer");
    }
}
