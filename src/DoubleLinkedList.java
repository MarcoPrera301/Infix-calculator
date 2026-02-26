public class DoubleLinkedList<T> extends AbstractList{
    private static class Node<T>{
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList(){
        super();
        this.head = null;
        this.tail = null;
    }
    @Override
    public void add(T item){
        Node<T> newNode = new Node<>(item);
        if (tail == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    @Override
    public T removeLast(){
        if (isEmpty()) return null;
            T value = tail.data;
        if (head == tail){
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return value;
    }
    @Override
    public T getLast(){
        if (isEmpty()) return null;
        return tail.data;
    }
}
    

