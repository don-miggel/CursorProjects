package my.depositFactory;

public class Utils {
    public static double monthsToDays(int months) {
        return ((double) months * 31) / 365;
    }

    public static double castPercentToDecimal(double percent) {
        return percent / 100;
    }
}
