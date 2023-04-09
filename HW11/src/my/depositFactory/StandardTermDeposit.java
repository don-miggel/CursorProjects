package my.depositFactory;

public class StandardTermDeposit extends Deposit {

    public StandardTermDeposit(double amount, double interestRate, int depositTerm) {
        super(amount, interestRate, depositTerm);
    }

    @Override
    public double calculateInterest() {
        double amountToPay = getAmount() * Utils.castPercentToDecimal(getInterestRate()) *
                Utils.monthsToDays(getDepositTerm());

        return Math.round(amountToPay * 100.0) / 100.0 ;
    }
}
