package my.car;

import java.util.ArrayList;
import java.util.Random;

public class CarGenerator {

    public static ArrayList<Car> generateCars(int carsAmount, double mileageStart, double mileageEnd,
                                              double priceStart, double priceEnd, int yearStart, int yearEnd) {

        int count = 0;
        Random r = new Random();
        double randomPrice = 0.0;
        double randomMileage = 0.0;
        int randomYear = 0;
        int randBrand = 0;
        ArrayList<Car> generatedCars = new ArrayList<>();
        while (count++ < carsAmount) {

            randomPrice = Math.round(priceStart + r.nextDouble(priceEnd - priceStart) * 100.0 / 100.0);
            randomMileage = Math.round(mileageStart + r.nextDouble(mileageEnd - mileageStart) * 100.0 / 100.0);
            randomYear = (int) Math.floor(Math.random() * (yearEnd - yearStart + 1) + yearStart);
            randBrand = r.nextInt(Brand.values().length);
            Car randCar = new Car(Brand.values()[randBrand], randomYear, randomMileage, randomPrice);
            generatedCars.add(randCar);

        }
        return generatedCars;
    }
}
