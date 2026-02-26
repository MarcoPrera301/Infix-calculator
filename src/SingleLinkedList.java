
public class SingleLinkedList<T> extends AbstractList<T>{
    private static class Node<T>{
        T data;
        Node<T> next;
        Node(T data ){
            this.data = data;
            this.next = null;
        }
    }
    private Node<T> head;
    public SingleLinkedList(){
        super();
        this.head = null;
    }
    @Override
    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    @Override
    public T removeLast(){
        if (isEmpty()) return null;
        T value;
        if (head.next == null){
            value = head.data;
            head = null;
        }
        else{
            Node<T> current = head;
            while (current.next.next != null){
                current = current.next;
            }
            value = current.next.data;
            current.next = null;
        }
        size--;
        return value;

    }
    @Override
    public T getLast() {
        if (isEmpty()) return null;
        Node<T> current = head;
        while (current.next != null){
            current = current.next;
        }
        return current.data;
    }
}
    

