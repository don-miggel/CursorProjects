package my.car;

import java.util.UUID;

public class Car {

    private UUID id;
    private Brand brand;
    private int year;
    private double mileage;
    private double price;

    Car(Brand brand, int year, double mileage, double price) {
        id = UUID.randomUUID();
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getId() {
        return id.toString();
    }

    public Brand getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
