package my.queuedoublell;

public class Main {

    public static void main(String[] args) {
        QueueDoubleLL<String> stringQueueDoubleLL = new QueueDoubleLL<>();
        System.out.println("Is queue empty: "+ stringQueueDoubleLL.isEmpty()+". It's size is: "
                +stringQueueDoubleLL.size()+" elements");
        stringQueueDoubleLL.enqueue("First");
        stringQueueDoubleLL.enqueue("Second");
        stringQueueDoubleLL.enqueue("Third");
        System.out.println("Is queue empty: "+ stringQueueDoubleLL.isEmpty()+". It's size is: "
                +stringQueueDoubleLL.size()+" elements");
        stringQueueDoubleLL.outputFromHead();
        System.out.println("Queue current head: "+ stringQueueDoubleLL.getHead());
        System.out.println("Queue current tail: "+stringQueueDoubleLL.getTail());
        System.out.println("Deleting an item from the head: "+stringQueueDoubleLL.dequeue());
        System.out.println("Output after deleting:");
        stringQueueDoubleLL.outputFromHead();
        System.out.println("Is queue empty: "+ stringQueueDoubleLL.isEmpty()+". It's size is: "
                +stringQueueDoubleLL.size()+" elements");
        System.out.println("Queue current head: "+ stringQueueDoubleLL.getHead());
        System.out.println("Queue current tail: "+stringQueueDoubleLL.getTail());
        System.out.println("Deleting an item from the head: "+stringQueueDoubleLL.dequeue());
        System.out.println("Is queue empty: "+ stringQueueDoubleLL.isEmpty()+". It's size is: "
                +stringQueueDoubleLL.size()+" elements");
        System.out.println("Output after deleting:");
        stringQueueDoubleLL.outputFromHead();
        System.out.println("Queue current head: "+ stringQueueDoubleLL.getHead());
        System.out.println("Queue current tail: "+stringQueueDoubleLL.getTail());
        System.out.println("Is queue empty: "+ stringQueueDoubleLL.isEmpty()+". It's size is: "
                +stringQueueDoubleLL.size()+" elements");
        System.out.println("Deleting an item from the head: "+stringQueueDoubleLL.dequeue());
        System.out.println("Is queue empty: "+ stringQueueDoubleLL.isEmpty()+". It's size is: "
                +stringQueueDoubleLL.size()+" elements");
        System.out.println("Queue current head: "+ stringQueueDoubleLL.getHead());
        System.out.println("Queue current tail: "+stringQueueDoubleLL.getTail());



    }


}
