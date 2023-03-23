package my.stack;

public class Fruit {

    private String name;
    private int count;

    Fruit(String name, int count){
        this.name = name;
        this.count = count;

    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
