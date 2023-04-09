import my.depositFactory.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Deposit deposit = initialize();
        if (deposit != null)
            System.out.println(deposit.calculateInterest());
    }

    public static Deposit initialize() {

        Deposit deposit = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose deposit type : 1 - Standard Term Deposit," +
                " 2 - Term Deposit With Interim Payment ");
        int depositChoice = sc.nextInt();
        if (depositChoice != 1 && depositChoice != 2){
            System.out.println("Invalid choice");
            return null;
        }
        System.out.println("Please enter an amount to calculate: ");
        double depositAmount = sc.nextDouble();
        System.out.println("Please, enter a deposit term");
        int depositTerm = sc.nextInt();
        System.out.println("Please, enter a deposit interest: ");
        double depositInterest = sc.nextDouble();
        switch (depositChoice) {

            case 1 -> {
                deposit = new StandardDepositFactory().create(depositAmount, depositInterest, depositTerm);
            }
            case 2 -> {
                deposit = new TermDepositFactory().create(depositAmount, depositInterest, depositTerm);
            }
        }
        return deposit;
    }
}
