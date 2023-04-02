import my.car.Brand;
import my.car.Car;
import my.car.CarGenerator;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Car> myCars = CarGenerator.generateCars(15, 10000, 52000, 5000
                , 32500, 2007, 2021);
        System.out.println(myCars);

        List<Car> selectedCars;

        // Get TESLA or AUDI
        selectedCars = myCars.stream()
                .filter(c -> c.getBrand().equals(Brand.TESLA) || c.getBrand().equals(Brand.AUDI))
                .collect(Collectors.toList());

        System.out.println("Tesla or Audi cars:" + '\n' + selectedCars);

        selectedCars = myCars.stream()
                .filter(c -> c.getYear() < 2018)
                .collect(Collectors.toList());

        System.out.println("Cars younger than 2018:" + '\n' + selectedCars);

        selectedCars = myCars.stream()
                .filter(c -> c.getMileage() < 40000)
                .collect(Collectors.toList());

        System.out.println("Cars with mileage less than 40000:" + '\n' + selectedCars);


        selectedCars = myCars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());

        System.out.println("Cars with prices sorted desc:" + '\n' + selectedCars);

        Map<String, Car> cheapest3Cars = myCars.stream()
                .sorted(Comparator.comparing(Car::getPrice))
                .limit(3)
                .collect(Collectors.toMap(Car::getId, Function.identity()));

        System.out.println("Map with 3 cheapest cars:" + '\n' + cheapest3Cars);

    }
}
