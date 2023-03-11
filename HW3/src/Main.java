import my.account.Account;
import my.account.CreditAccount;
import my.account.DebitAccount;
import my.bank.Bank;
import my.user.BankClient;

public class Main {
    public static void main(String[] args) {

        // the whole output of the code below is demonstrated in the testing_results.txt in the HW3 folder

        Bank bank1 = new Bank("Mono", "MNB");
        System.out.println(Bank.getAmountOfAccounts());
        System.out.println(bank1);

        // We are testing here BankClient class
        BankClient mykola = new BankClient(456, "Mykola", 24, "mykola@ukr.net",
                "050 111 22 33", "000", "Lviv, Rynok Square");

        // Creating credit1 setting up parameters via parametrized constructor
        Account credit1 = new CreditAccount("123", 11000.0, mykola, bank1);
        //test output operation
        System.out.println(credit1);

        // We are testing here CreditAccount class
        credit1.getAccountBalance();
        CreditAccount.getWithdrawCommission();
        ((CreditAccount) credit1).withdraw(75.6);
        System.out.println(credit1);
        ((CreditAccount) credit1).withdraw(20.6);
        System.out.println(credit1);

        BankClient ivan = new BankClient(756, "Ivan", 28, "ivan@ukr.net",
                "050 222 33 45", "111", "Kyiv, Khreshatik");

        // Creating credit2 setting up parameters manually
        Account credit2 = new CreditAccount();
        credit2.setBank(bank1);

        credit2.setUser(ivan);
        credit2.setAccountBalance(8900.0);
        credit2.setAccountNumber("369");
        System.out.println(credit2);
        CreditAccount.setWithdrawCommission(15.0);
        ((CreditAccount) credit2).withdraw(5217.69);
        System.out.println("The balance of credit2 is "+ credit2.getAccountBalance());

        // Creating debit1 setting up parameters via parametrized constructor
        Account debit1 = new DebitAccount("159", 3769.22, mykola, bank1);
        System.out.println(debit1);
        ((DebitAccount) debit1).withdraw(2157.33);
        System.out.println("The balance of debit1 is "+ debit1.getAccountBalance());
        ((DebitAccount) debit1).withdraw(3157.33);
        System.out.println("The balance of debit1 is "+ debit1.getAccountBalance());

        // Creating debit2 setting up parameters manually
        Account debit2 = new DebitAccount();
        debit2.setAccountNumber("741");
        debit2.setAccountBalance(5423.67);
        debit2.setUser(ivan);
        debit2.setBank(bank1);
        System.out.println(debit2);
        ((DebitAccount) debit2).withdraw(1532.78);
        System.out.println("The balance of debit1 is "+ debit2.getAccountBalance());
        ((DebitAccount) debit2).withdraw(3157.33);
        System.out.println("The balance of debit1 is "+ debit2.getAccountBalance());
        ((DebitAccount) debit2).withdraw(3157.33);
        System.out.println("The balance of debit1 is "+ debit2.getAccountBalance());

        System.out.println(bank1);
        bank1.addAccount(credit1);
        System.out.println(bank1);

        bank1.addAccount(credit2);
        System.out.println(bank1);

        bank1.addAccount(debit1);
        System.out.println(bank1);

        bank1.addAccount(debit2);
        System.out.println(bank1);
        System.out.println(Bank.getAmountOfAccounts());

        bank1.removeAccount(debit2);
        System.out.println(bank1);
        System.out.println(Bank.getAmountOfAccounts());

        bank1.removeAccount(debit1);
        System.out.println(bank1);
        System.out.println(Bank.getAmountOfAccounts());

        bank1.removeAccount(credit2);
        System.out.println(bank1);
        System.out.println(Bank.getAmountOfAccounts());

        bank1.removeAccount(credit1);
        System.out.println(bank1);
        System.out.println(Bank.getAmountOfAccounts());














    }
}
