import java.util.ArrayList;
import java.util.List;

public class MyListTwo<T extends Comparable<T>> {

    List<T> myArr;

    MyListTwo() {
        myArr = new ArrayList<>();
    }

    public void add(T elem) {
        myArr.add(elem);
    }

    @Override
    public String toString() {
        return "MyListTwo{" +
                "myArr=" + myArr +
                '}';
    }

    public static void main(String[] args) {

        MyListTwo<String> strMyList = new MyListTwo<>();
        strMyList.add("Java");
        strMyList.add("GO");
        strMyList.add("C++");
        System.out.println(strMyList);

        MyListTwo<Integer> intMyList = new MyListTwo<>();
        intMyList.add(1789);
        intMyList.add(-52);
        intMyList.add(963);
        intMyList.add(1826);
        intMyList.add(752);
        System.out.println(intMyList);

    }

}
