public class StackFactory{
    public static <T> Stack<T> createStack(String stackType, String listType){
        switch (stackType.trim().toLowerCase()){
            case "1":
            case "arraylist":
                return new ArrayListStack<>();
            case "2":
            case "vector":
                return new VectorStack<>();
            case "3":
            case "list":
              IList<T> list = ListFactory.createList(listType);
                return new ListStack<>(list);
            default:
                return null;
        }
    }
}