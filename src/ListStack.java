public class ListStack<T> extends AbstractStack<T> {
    private final IList<T> list;

    public ListStack(List<T> list){
        super();
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.add(item);
        size++;
    }

    @Override
    public T pop(){
        if (isEmpty()) return null;
        size--;
        return list.removeLast();
    }

    @Override
    public T peek(){
        if (isEmpty()) return null;
        return list.getLast();
    }

}
    

