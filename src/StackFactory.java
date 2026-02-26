public class StackFactory{
    public static <T> Stack<T> createStack(String stackType, String listType){
        switch (stackType.trim().toLowerCase()){
            case "arraylist":
                return new ArrayListStack<>();
            case "vector":
                return new VectorStack<>();
            case "list":
                List<T> list = ListFactory.createlist(listType);
                return new ListStack<>(list);
            default:
                return null;
        }
    }
}