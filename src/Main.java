import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione implementación del stack:");
        System.out.println("  [1] ArrayList  [2] Vector  [3] Lista");
        System.out.print("Opción: ");
        String stackChoice = scanner.nextLine().trim();

        String listChoice = null;
        if (stackChoice.equals("3")) {
            System.out.println("Seleccione lista: [1] Singly  [2] Doubly");
            System.out.print("Opción: ");
            listChoice = scanner.nextLine().trim();
        }

        ArrayList<String> lines = FileConverter.parseFile("datos.txt");

        Calculator calculator = Calculator.getInstance();

        for (String line : lines) {
            ArrayList<String> single = new ArrayList<>();
            single.add(line);

            String postfix = FileConverter.infixToPostfix(single, StackFactory.createStack(stackChoice, listChoice));
            System.out.println("Infix: " + line + " | Postfix: " + postfix);

            double result = calculator.operate(postfix, StackFactory.createStack(stackChoice, listChoice));
            System.out.println("Resultado: " + result);
        }

        scanner.close();
    }
}