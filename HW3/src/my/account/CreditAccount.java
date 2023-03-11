package my.account;

import my.bank.Bank;
import my.user.BankClient;

public class CreditAccount extends Account {
    private Double accountLimit = 0.0;
    private static double WITHDRAW_COMMISSION = 10.0;

    public CreditAccount() {
    }

    public CreditAccount(String accountNumber, double accountBalance, BankClient user, Bank bank) {
        super(accountNumber, accountBalance, user, bank);
        processClientData(user);
    }

    private void processClientData(BankClient user){
        if(user.getAge() < 25){
            this.accountLimit = 100.0;
//            System.out.println("You are younger than 25 years old and both your account limit and account balance are set to 100.0 ");
        }
        else  {
            this.accountLimit = 10000.0;
        }
        if (this.accountBalance > accountLimit) {
            this.accountBalance = accountLimit;
        }
    }

    public static void setWithdrawCommission(double withdrawCommission) {
        WITHDRAW_COMMISSION = withdrawCommission;
    }

    public static void getWithdrawCommission() {
        System.out.println("The current withdraw commission is " + WITHDRAW_COMMISSION+" percent");
    }

    public void getAccountLimit() {
        System.out.println("The account limit is "+ accountLimit);

    }

    public void setUser(BankClient user) {
        if (accountBalance != null)
            processClientData(user);
        else
            return;
    }

    /*
    public void setAccountBalance(Double accountBalance) {

        // we cannot set up an account balance, which exceeds our account limit
        if (accountBalance > accountLimit)
            System.out.println("You cannot set up " + accountBalance + " which exceeds your account limit " + accountLimit);
        else
            this.accountBalance = accountBalance;
    }
    */


    public void withdraw(Double amount) {

        // amount of money to be received by the client after commission subtraction
        double moneyAfterCommission = amount - amount * (WITHDRAW_COMMISSION / 100);
        moneyAfterCommission = Math.round(moneyAfterCommission * 100.0) / 100.0;
        /*
        if (amount > this.getAccountBalance()) {
            System.out.println("Your current balance is: " + this.getAccountBalance() +
                    ", which is less than  amount you want to withdraw: " + amount);
        } else
            System.out.println("Credit account has " + WITHDRAW_COMMISSION + "% commission. You will get " +
                    moneyAfterCommission);

         */
        System.out.println("Credit account has " + WITHDRAW_COMMISSION + "% commission. You will get " +
                moneyAfterCommission);
        this.accountBalance -= amount;
        this.accountBalance = Math.round(this.accountBalance * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "CreditAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", user=" + user +
                ", bank=" + bank +
                ", accountLimit=" + accountLimit +
                '}';
    }

}
