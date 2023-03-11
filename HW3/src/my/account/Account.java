package my.account;

import my.bank.Bank;
import my.user.BankClient;

public class Account {

    protected String accountNumber;
    protected Double accountBalance;
    protected BankClient user;
    protected Bank bank;

    public Account() {
    }

    public Account(String accountNumber, double accountBalance, BankClient user, Bank bank) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.user = user;
        this.bank = bank;

    }

    protected void withdraw(Double amount) {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountBalance() {
 //       System.out.println("Your current balance is: "+ accountBalance);
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BankClient getUser() {
        return user;
    }

    public void setUser(BankClient user) {
        this.user = user;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", user=" + user +
                ", bank=" + bank +
                '}';
    }
}
