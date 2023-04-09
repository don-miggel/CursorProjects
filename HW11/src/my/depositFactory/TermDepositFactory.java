package my.depositFactory;

public class TermDepositFactory extends DepositFactory{

    @Override
    protected Deposit createDeposit(double amount, double interestRate, int depositTerm) {
        return new TermDepositWithInterimPayment(amount, interestRate, depositTerm);
    }
}
