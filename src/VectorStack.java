import java.util.Vector;

public class VectorStack<T> extends AbstractStack<T> {
    private final Vector<T> data;

    public VectorStack(){
        super();
        this.data = new Vector<>();
    }

    @Override
    public void push(T item){
        data.add(item);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        size--;
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek(){
        if (isEmpty()) return null;
        return data.get(data.size() - 1);
    }
}
    

