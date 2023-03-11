package my.bank;

import my.account.Account;

public class Bank {

    private String bankCode;
    private String bankName;
    private Double moneyAmount;
    private static int amountOfAccounts = 0;

    public Bank(String bankName, String bankCode) {
        this.bankName = bankName;
        this.bankCode = bankCode;
        moneyAmount = 4000.0;
    }

    public void addAccount(Account account) {
        moneyAmount += account.getAccountBalance();
        amountOfAccounts++;
        moneyAmount = Math.round(moneyAmount * 100.0) / 100.0;
        System.out.println("Account " + account.getAccountNumber() + " was added!");

    }

    public void removeAccount(Account account) {
        if (account.getAccountBalance() < 0) {
            System.out.println("Account cannot be removed. The client has a credit");
            return;
        }
        moneyAmount -= account.getAccountBalance();
        amountOfAccounts--;
        moneyAmount = Math.round(moneyAmount * 100.0) / 100.0;
        System.out.println("Account " + account.getAccountNumber() + " was removed!");

    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public static String getAmountOfAccounts() {
        return "Total amount of clients of all banks is " + amountOfAccounts;
    }

    public String getMoneyAmountInfo() {
        return "Total amount of money in " + getBankName() + " is " + moneyAmount;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankCode='" + bankCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", moneyAmount=" + moneyAmount +
                '}';
    }


}
