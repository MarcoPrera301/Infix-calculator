import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      Calculadora Infix - HT4     ║");
        System.out.println("╚══════════════════════════════════╝\n");

        // ── Factory Pattern: elegir implementación del Stack ──────────────────
        System.out.println("Seleccione implementación del stack:");
        System.out.println("  [1] ArrayList");
        System.out.println("  [2] Vector");
        System.out.println("  [3] Lista");
        System.out.print("Opción: ");
        String stackChoice = scanner.nextLine().trim();

        String listChoice = null;
        if (stackChoice.equals("3") || stackChoice.equalsIgnoreCase("list")) {
            System.out.println("\nSeleccione implementación de la lista:");
            System.out.println("  [1] Simplemente encadenada (Singly)");
            System.out.println("  [2] Doblemente encadenada (Doubly)");
            System.out.print("Opción: ");
            listChoice = scanner.nextLine().trim();
        }

        // ── Leer y convertir expresión del archivo ────────────────────────────
        String filePath = "datos.txt";
        java.util.ArrayList<String> lines = FileConverter.parseFile(filePath);

        if (lines == null || lines.isEmpty()) {
            System.err.println("Error: datos.txt está vacío o no fue encontrado.");
            scanner.close();
            return;
        }

        // ── Singleton Pattern: única instancia de Calculator ──────────────────
        Calculator calculator = Calculator.getInstance();

        System.out.println("\n──────────────────────────────────────");

        for (String line : lines) {
            System.out.println("Infix:   " + line);

            // Stack para conversión (siempre necesita uno limpio)
            Stack<String> conversionStack = StackFactory.createStack(stackChoice, listChoice);
            String postfix = FileConverter.infixToPostfix(
                new java.util.ArrayList<>(java.util.Arrays.asList(line)),
                conversionStack
            );
            System.out.println("Postfix: " + postfix);

            // Stack para evaluación (siempre uno limpio por expresión)
            Stack<Double> evalStack = StackFactory.createStack(stackChoice, listChoice);

            try {
                double result = calculator.operate(postfix, evalStack);

                // Mostrar como entero si no tiene decimales
                if (result == Math.floor(result) && !Double.isInfinite(result)) {
                    System.out.println("Resultado: " + (long) result);
                } else {
                    System.out.println("Resultado: " + result);
                }
            } catch (Exception e) {
                System.err.println("Error al evaluar: " + e.getMessage());
            }

            System.out.println("──────────────────────────────────────");
        }

        scanner.close();
    }
}