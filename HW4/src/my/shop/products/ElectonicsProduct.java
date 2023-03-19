package my.shop.products;

import my.shop.enums.ClientRestrictionStatus;

import java.time.LocalDate;

public abstract class ElectonicsProduct extends Product {

    private LocalDate guaranteeExpDate;

    ElectonicsProduct(String name, double price, int quantity, ClientRestrictionStatus ageRestriction, int monthsAmount) {
        super(name, price, quantity, ageRestriction);
        LocalDate expDate = LocalDate.now().plusMonths(monthsAmount);
        guaranteeExpDate = expDate;

    }

    public LocalDate getGuaranteeExpDate() {
        return guaranteeExpDate;
    }

    public void changeGuaranteeExpDate(int guaranteeYearExp,
                                       int guaranteeMonExp, int guaranteeDayExp) {
        guaranteeExpDate = LocalDate.of(guaranteeYearExp, guaranteeMonExp, guaranteeDayExp);
    }

    @Override
    public String toString() {
        return "ElectonicsProduct{" +
                super.toString() +
                " guaranteeExpDate=" + guaranteeExpDate +
                '}';
    }
}
