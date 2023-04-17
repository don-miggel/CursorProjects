package view.impl;

import model.Admin;
import model.Product;
import model.ProductWarehouse;
import view.Menu;

import java.util.Scanner;

public class ProductChangeMenu implements Menu {

    Admin adm = null;
    AdminMenu adminMenu = null;

    ProductChangeMenu(AdminMenu adminMenu, Admin adm) {
        this.adm = adm;
        this.adminMenu = adminMenu;
    }

    @Override
    public void show() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Change product name");
        System.out.println("2. Change product category");
        System.out.println("3. Change product price");
        System.out.println("4. Change product quantity");
        System.out.println("5. Add new product");
        System.out.println("6. Return to previous menu");
        int admChoice = sc.nextInt();

        switch (admChoice) {

            case 1:
                changeProductTemplate("name");
                show();
                break;
            case 2:
                changeProductTemplate("category");
                show();
                break;
            case 3:
                changeProductTemplate("price");
                show();
                break;
            case 4:
                changeProductTemplate("qty");
                show();
                break;
            case 5:
                adm.addNewProduct();
                show();
                break;
            case 6:
                exit();
                break;
            default:
                System.out.println("Invalid choice !");
                show();
        }

    }

    private void changeStringField(String fieldToChange, String newValue, Product chosenProd) {

        switch (fieldToChange) {
            case "name":
                chosenProd.setProdName(newValue);
                System.out.println("Product " + fieldToChange + " with Id: " + chosenProd.getProdId() + " was changed to: " +
                        chosenProd.getProdName());
                break;
            case "category":
                chosenProd.changeCategory(newValue);
                System.out.println("Product " + fieldToChange + " with Id: " + chosenProd.getProdId() + " was changed to: " +
                        chosenProd.getProdName());
                break;
        }
    }

    private void changeProductTemplate(String fieldToChange) {
        ProductWarehouse.displayAllProds();
        System.out.println("Enter product Id:");
        Scanner scNumbers = new Scanner(System.in);
        Scanner scText = new Scanner(System.in);
        int prodId = scNumbers.nextInt();
        Product chosenProd = ProductWarehouse.getProductById(prodId);
        if (chosenProd != null) {
            System.out.println("Enter new product " + fieldToChange);
            if (fieldToChange.equals("category") || fieldToChange.equals("name")) {

                String newValue = scText.nextLine();
                changeStringField(fieldToChange, newValue, chosenProd);
            }
            if (fieldToChange.equals("qty")) {

                int newQty = scNumbers.nextInt();
                chosenProd.setProdQty(newQty);
                System.out.println("Product " + fieldToChange + "of product with Id: " + chosenProd.getProdId() + " was changed to: " +
                        chosenProd.getProdQty());
            }
            if (fieldToChange.equals("price")) {
                double newPrice = scNumbers.nextDouble();
                chosenProd.setProdPrice(newPrice);
                System.out.println("Product " + fieldToChange + "of product with Id: " + chosenProd.getProdId() + " was changed to: " +
                        chosenProd.getProdPrice());
            }

        } else {
            System.out.println("Product with Id: " + prodId + " does not exist! ");
        }
    }

    @Override
    public void exit() {
        adminMenu.show();
    }
}
