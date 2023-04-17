import model.*;
import view.impl.LoginMenu;

public class Main {
    public static void main(String[] args) {

        User joe = UserManager.createClient("Joe", "Doe", "joe@doe.com", "000", 1500.00);
        User frank = UserManager.createClient("Frank", "Jones", "frank@jones.com", "010", 2100.00);
        User katty = UserManager.createClient("Katty", "Davis", "katty@davis.com", "123", 2750.00);

        User dave = UserManager.createAdmin("David", "Smith", "dave@smith.com", "111");

        ProductWarehouse.prepopulateProducts();
        new LoginMenu().show();
    }

}
