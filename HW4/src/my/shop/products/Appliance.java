package my.shop.products;

import my.shop.enums.ClientRestrictionStatus;

public class Appliance extends ElectonicsProduct {

    public Appliance(String name, double price, int quantity, ClientRestrictionStatus ageRestriction) {
        super(name, price, quantity, ageRestriction, 6);
    }

    @Override
    public double getPrice() {
        return (quantity < 50) ? price * 1.05 : price;
    }

    @Override
    public String toString() {
        return super.toString().replace("ElectonicsProduct", "Appliance");
    }

}
