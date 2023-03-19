package my.shop.customers;

public class Customer {

    private String name;
    private int age;
    private double balance;

    public Customer(String name, int age, double balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    Customer(String name, int age) {
        this.name = name;
        this.age = age;
        balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void reduceBalance(double reduceAmount) {
        if (reduceAmount > 0.0) {
            balance -= reduceAmount;
            balance = Math.round(balance * 100.0) / 100.0;
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
