package my.doublyLL;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> integerDoublyLinkedList = new DoublyLinkedList<>();
        integerDoublyLinkedList.addFirst(10);
        integerDoublyLinkedList.addFirst(3);
        integerDoublyLinkedList.addFirst(9);
        integerDoublyLinkedList.addFirst(14);
        integerDoublyLinkedList.addFirst(17);
        integerDoublyLinkedList.addLast(24);
        integerDoublyLinkedList.addLast(35);
        System.out.println("output from head");
        integerDoublyLinkedList.outputFromHead();
        System.out.println("It's current size is: "+ integerDoublyLinkedList.size());
        System.out.println("get current tail");
        integerDoublyLinkedList.getTail();
        System.out.println("output from tail");
        integerDoublyLinkedList.outputFromTail();
        integerDoublyLinkedList.add(42, 26);
        integerDoublyLinkedList.add(42, 3);
        integerDoublyLinkedList.add(115, 0);
        integerDoublyLinkedList.add(15, integerDoublyLinkedList.size());
        System.out.println("It's current size is: "+ integerDoublyLinkedList.size());
        integerDoublyLinkedList.outputFromTail();
        System.out.println("output from tail after adding 4 elements");
        System.out.println("GET tail");
        integerDoublyLinkedList.getTail();
        System.out.println("output from head");
        integerDoublyLinkedList.outputFromHead();

        integerDoublyLinkedList.removeFromTail();
        System.out.println("get tail after deleting");
        integerDoublyLinkedList.getTail();
        integerDoublyLinkedList.removeFromTail();
        System.out.println("get tail after deleting");
        integerDoublyLinkedList.getTail();
        System.out.println("output after removing from tail");
        integerDoublyLinkedList.outputFromHead();

        System.out.println("remove from tail");
        integerDoublyLinkedList.removeFromTail();
        integerDoublyLinkedList.getTail();
        System.out.println("remove from head");
        integerDoublyLinkedList.removeFromHead();
        System.out.println(integerDoublyLinkedList.getHead());
        System.out.println("remove from tail");
        integerDoublyLinkedList.removeFromTail();
        integerDoublyLinkedList.getTail();
        System.out.println("remove from head");
        integerDoublyLinkedList.removeFromHead();
        System.out.println(integerDoublyLinkedList.getHead());

        integerDoublyLinkedList.removeFromTail();
        System.out.println("current tail");
        integerDoublyLinkedList.getTail();
        System.out.println("current head");
        System.out.println(integerDoublyLinkedList.getHead());
        System.out.println("output from tail");
        integerDoublyLinkedList.outputFromTail();
        System.out.println("output from head");
        integerDoublyLinkedList.outputFromHead();
        System.out.println("current size: "+ integerDoublyLinkedList.size());
    }
}
