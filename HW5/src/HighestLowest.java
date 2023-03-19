import java.util.ArrayList;

public class HighestLowest<T extends Comparable<T>> extends MyListTwo<T> {

    HighestLowest() {
        super();
    }

    public T largest() {
        if (myArr.size() < 1) {
            return null;
        }

        T largestElem = myArr.get(0);
        for (T elem : myArr) {
            if (elem.compareTo(largestElem) > 0) {
                largestElem = elem;
            }
        }
        return largestElem;
    }

    public T smallest() {
        if (myArr.size() < 1) {
            return null;
        }

        T largestElem = myArr.get(0);
        for (T elem : myArr) {
            if (elem.compareTo(largestElem) < 0) {
                largestElem = elem;
            }
        }
        return largestElem;

    }

    @Override
    public String toString() {
        return super.toString().replace("MyListTwo", this.getClass().getTypeName());
    }

    public static void main(String[] args) {
        System.out.println("-------------STRING--------------");
        HighestLowest<String> strMyList = new HighestLowest<>();
        strMyList.add("Java");
        strMyList.add("GO");
        strMyList.add("C++");
        strMyList.add("Python");
        strMyList.add("Unity");
        strMyList.add("Scala");
        strMyList.add("PHP");
        strMyList.add("Kotlin");
        System.out.println("Largest string: " + strMyList.largest());
        System.out.println("Smallest string: " + strMyList.smallest());
        System.out.println(strMyList);

        System.out.println("-------------INTEGER--------------");
        HighestLowest<Integer> intMyList = new HighestLowest<>();
        intMyList.add(1789);
        intMyList.add(-52);
        intMyList.add(963);
        intMyList.add(1826);
        intMyList.add(752);
        System.out.println("Largest integer: " + intMyList.largest());
        System.out.println("Smallest integer: " + intMyList.smallest());
        System.out.println(intMyList);

        System.out.println("-------------DOUBLE--------------");
        HighestLowest<Double> doubleMyList = new HighestLowest<>();
        doubleMyList.add(7.253_642_553_252);
        doubleMyList.add(89.253_642_553_252);
        doubleMyList.add(785.253_642_553_252);
        doubleMyList.add(229.253_642_553_252_182);
        doubleMyList.add(9.253_642_553_252_182);
        System.out.println("Largest double: " + doubleMyList.largest());
        System.out.println("Smallest double: " + doubleMyList.smallest());
        System.out.println(doubleMyList);

        System.out.println("-------------CHARACTER--------------");
        HighestLowest<Character> charMyList = new HighestLowest<>();
        charMyList.add('O');
        charMyList.add('R');
        charMyList.add('A');
        charMyList.add('C');
        charMyList.add('L');
        charMyList.add('E');
        System.out.println("Largest char: " + charMyList.largest());
        System.out.println("Smallest char: " + charMyList.smallest());
        System.out.println(charMyList);

        System.out.println("-------------LONG--------------");
        HighestLowest<Long> longMyList = new HighestLowest<>();
        longMyList.add(49_152_436_758L);
        longMyList.add(259_159_486_759L);
        longMyList.add(259_159_486_760L);
        longMyList.add(89_152_436_758L);
        longMyList.add(9_152_436_758L);
        System.out.println("Largest long: " + longMyList.largest());
        System.out.println("Smallest long: " + longMyList.smallest());
        System.out.println(longMyList);
    }

}
