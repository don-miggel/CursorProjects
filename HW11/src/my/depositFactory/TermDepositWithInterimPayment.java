package my.depositFactory;

public class TermDepositWithInterimPayment extends Deposit {

    public TermDepositWithInterimPayment(double amount, double interestRate, int depositTerm){
        super(amount, interestRate, depositTerm);
    }

    @Override
    public double calculateInterest() {
        double amountToPayMonthly = getAmount() * Utils.castPercentToDecimal(getInterestRate()) * Utils.monthsToDays(1);
        return Math.round(amountToPayMonthly * 100.0) / 100.0 ;
    }
}
