import java.util.ArrayList;
import java.util.List;

public class MyList<T extends Number> {
    List<T> myArr;

    MyList() {
        myArr = new ArrayList<>();
    }

    public void add(T elem) {
        myArr.add(elem);
    }

    public T largest() {
        if (myArr.size() < 1) {
            return null;
        }

        T largestElem = myArr.get(0);
        for (T elem : myArr) {
            if (largestElem.doubleValue() < elem.doubleValue()) {
                largestElem = elem;
            }
        }
        return largestElem;

    }

    public T smallest() {
        if (myArr.size() < 1) {
            return null;
        }

        T smallestElem = myArr.get(0);
        for (T elem : myArr) {
            if (smallestElem.doubleValue() > elem.doubleValue()) {
                smallestElem = elem;
            }
        }
        return smallestElem;

    }

    public static void main(String[] args) {
        MyList<Integer> myListInt = new MyList<>();
        myListInt.add(7);
        myListInt.add(12);
        myListInt.add(8);
        myListInt.add(-3);
        System.out.println("Largest Int: " + myListInt.largest());
        System.out.println("Smallest Int: " + myListInt.smallest());

        MyList<Double> myListDouble = new MyList<>();
        myListDouble.add(7.2536);
        myListDouble.add(12.25365);
        myListDouble.add(2.252653265365);
        myListDouble.add(7.25367);
        myListDouble.add(12.25366);
        System.out.println("Largest Double: " + myListDouble.largest());
        System.out.println("Smallest Double: " + myListDouble.smallest());

        MyList<Float> myListFlt = new MyList<>();
        myListFlt.add(3.14f);
        myListFlt.add(2.71f);
        myListFlt.add(0.25f);
        myListFlt.add(1.79f);
        System.out.println("Largest Float: " + myListFlt.largest());
        System.out.println("Smallest Float: " + myListFlt.smallest());

        MyList<Long> myListLng = new MyList<>();
        myListLng.add(49_152_436_758L);
        myListLng.add(259_159_486_759L);
        myListLng.add(259_159_486_760L);
        myListLng.add(89_152_436_758L);
        myListLng.add(9_152_436_758L);
        System.out.println("Largest Long: " + myListLng.largest());
        System.out.println("Smallest Long: " + myListLng.smallest());
    }

}




