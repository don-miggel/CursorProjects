package my.depositFactory;

public abstract class Deposit implements Interest {

    private final double amount;
    private final double interestRate;
    private final int depositTerm;

    Deposit(double amount, double interestRate, int depositTerm) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.depositTerm = depositTerm;
    }

    protected double getAmount() {
        return amount;
    }

    protected double getInterestRate() {
        return interestRate;
    }

    protected int getDepositTerm() {
        return depositTerm;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "amount=" + amount +
                ", interestRate=" + interestRate +
                ", depositTerm=" + depositTerm +
                '}';
    }
}
