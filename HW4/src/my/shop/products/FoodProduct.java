package my.shop.products;

import my.shop.enums.ClientRestrictionStatus;
import my.shop.interfaces.Expirable;

import java.time.LocalDate;
import java.util.Date;

public class FoodProduct extends Product implements Expirable {

    private LocalDate expDate;

    public FoodProduct(String name, double price, int quantity, ClientRestrictionStatus ageRestriction, int expYear, int expMon, int expDay) {
        super(name, price, quantity, ageRestriction);
        this.expDate = LocalDate.of(expYear, expMon, expDay);
    }

    public LocalDate getExpirationDate() {
        return expDate;
    }

    @Override
    public double getPrice() {
        LocalDate daysLeft = getExpirationDate().minusDays(15);
        double priceUpd = price;
        if (daysLeft.compareTo(LocalDate.now()) < 0) {
            priceUpd = Math.round((price - price * 0.7) * 100.0) / 100.0; // Math.round(moneyAmount * 100.0) / 100.0
        }
        return priceUpd;
    }

    public void setExpDate(int yearExp, int monthExp, int dayExp) {
        this.expDate = LocalDate.of(yearExp, monthExp, dayExp);
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                super.toString() +
                " expDate=" + expDate +
                '}';
    }
}
