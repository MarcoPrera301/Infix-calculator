public interface IList<T> {
    void add(T item);
    T removeLast();
    T getLast();
    boolean isEmpty();
    int size();
    
} 