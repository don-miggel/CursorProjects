package my.depositFactory;

public abstract class DepositFactory {

    public Deposit create(double amount, double interestRate, int depositTerm){
        Deposit myDeposit = createDeposit(amount, interestRate, depositTerm);
        myDeposit.calculateInterest();
        System.out.println(myDeposit);
        return myDeposit;
    }

    protected abstract  Deposit createDeposit(double amount, double interestRate,int depositTerm);

}
