package my.queuedoublell;

import my.doublyLL.DoublyLinkedList;

public class QueueDoubleLL<T> extends DoublyLinkedList<T> {

    public T enqueue(T data) {
        super.addLast(data);
        return super.getTail();
    }

    public T dequeue() {
        return super.removeFromHead();
    }

}
