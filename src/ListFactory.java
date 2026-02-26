public class ListFactory 
{
    public static <T> List<T> createlist(String type){
        switch (type.trim().toLowerCase()){
            case "single":
                return new SingleLinkedList<>();
            case "double":
                return new DoubleLinkedList<>();
            default:
                return null;
    }
}
