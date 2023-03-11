package my.account;

import my.account.Account;
import my.bank.Bank;
import my.user.BankClient;

public class DebitAccount extends Account {

    public DebitAccount(){}

    public DebitAccount(String accountNumber, double accountBalance, BankClient user, Bank bank) {
        super(accountNumber, accountBalance, user, bank);

    }

    public void withdraw(Double amount){
        if (accountBalance < amount)
            System.out.println("You request to withdraw amount of money "+amount+
                    ", that exceeds your balance "+accountBalance);
        else {
            System.out.println("You will get money without any commission: " + amount);
            accountBalance -= amount;
            accountBalance = Math.round(accountBalance * 100.0) / 100.0;
        }
    }

    @Override
    public String toString() {
        return "DebitAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", user=" + user +
                ", bank=" + bank +
                '}';
    }
}
