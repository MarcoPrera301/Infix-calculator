public class ListFactory {

    public static <T> IList<T> createList(String type) {
        switch (type.trim().toLowerCase()) {
            case "1":
            case "single":
                return new SingleLinkedList<>();
            case "2":
            case "double":
                return new DoubleLinkedList<>();
            default:
                throw new IllegalArgumentException(
                    "Tipo de lista desconocido: '" + type + "'. Opciones: singly, doubly");
        }
    }
}