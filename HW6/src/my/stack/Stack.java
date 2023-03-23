package my.stack;

public class Stack <T>{

    private class Node<T> {
        private T item;
        private Node<T> node;

        public Node(T item, Node<T> node){
            this.item = item;
            this.node = node;
        }
    }

    private Node<T> head;

    public Stack(){
        head = null;
    }

    public void push(T item){

        head = new Node<>(item, head);
    }

    public T pop(){
        if (head == null)
            throw new IllegalStateException();
        T itemToGet = head.item;
        head = head.node;
        return itemToGet;
    }

    public int size(){
        int countElems = 0;
        Node<T> current = head;
        while (current != null){
            countElems++;
            current = current.node;
        }
        return countElems;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T top(){
        return head.item;
    }

    public void output(){

        Node<T> current = head;
        while (current != null){
            System.out.println(current.item);
            current = current.node;
        }
    }
}
