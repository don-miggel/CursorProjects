package view.impl;

import model.ProductWarehouse;
import view.Menu;

import java.util.Scanner;

public class ProductSearchMenu implements Menu {

    ClientMenu clm = null;

    ProductSearchMenu(ClientMenu clm) {
        this.clm = clm;
    }

    @Override
    public void show() {
        Scanner scDigits = new Scanner(System.in);
        Scanner scText = new Scanner(System.in);
        int searchChoice = 0;
        System.out.println("Choose an operation:");
        System.out.println("1. Search product by name");
        System.out.println("2. Search product by brand");
        System.out.println("3. Search product by category");
        System.out.println("4. Search product in the price range");
        System.out.println("5. Return to Client menu");
        searchChoice = scDigits.nextInt();
        String searchParameters;
        switch (searchChoice) {

            case 1 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Please enter a word, a product name may contain:");
                searchParameters = scText.nextLine();
                System.out.println(searchParameters);
                ProductWarehouse.searchByName(searchParameters);
                show();
            }
            case 2 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Please enter a word, a product brand may contain:");
                searchParameters = scText.nextLine();
                ProductWarehouse.searchByBrand(searchParameters);
                show();
            }
            case 3 -> {
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Please enter a word, a product category may contain:");
                searchParameters = scText.nextLine();
                ProductWarehouse.searchByCategory(searchParameters);
                show();
            }
            case 4 -> {
                double startPrice = 0.0, endPrice = 0.0;
                System.out.println("Please enter a price range:");
                System.out.println("Price starts at :");
                startPrice = scDigits.nextDouble();
                System.out.println("Price ends at :");
                endPrice = scDigits.nextDouble();
                if (startPrice > endPrice) {
                    System.out.println("Start price should be less than or equal to the end price");
                    show();
                }
                ProductWarehouse.searchProdsInPriceRange(startPrice, endPrice);
                show();
            }
            case 5 -> clm.show();
            default -> {
                System.out.println("Wrong menu item");
                show();
            }
        }
    }

    @Override
    public void exit() {
        clm.show();
    }
}
