package my.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Fruit> fruits = new Stack<>();
        System.out.println(fruits.isEmpty());
        fruits.push(new Fruit("Apple", 15));
        System.out.println(fruits.isEmpty());
        fruits.push(new Fruit("Pear", 10));
        fruits.push(new Fruit("Bananas", 23));
        fruits.push(new Fruit("Ananas", 17));
        System.out.println("-----------Output of all the elements---------");
        fruits.output();
        System.out.println("fruits amount of: "+fruits.size());
        System.out.println("Popping top element from the stack fruits: "+ fruits.pop());
        System.out.println("Current top element is:" + fruits.top());
        System.out.println("-----------Output after deleting top element---------");
        fruits.output();
        System.out.println("fruits amount of: "+fruits.size());

    }
}
