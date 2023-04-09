package my.depositFactory;

public class StandardDepositFactory extends DepositFactory{

    @Override
    protected Deposit createDeposit(double amount, double interestRate, int depositTerm) {
        return new StandardTermDeposit(amount, interestRate, depositTerm);
    }
}
