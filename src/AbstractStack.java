public abstract class AbstractStack<T> implements Stack<T>{
    protected int size;

    public AbstractStack(){
        this.size = 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }
}
    

