import java.io.File;

public class Main {
    public static void main(String[] args) 
    {
        FileConverter.parseFile("datos.txt");
        String postfix = FileConverter.infixToPostfix(FileConverter.parseFile("datos.txt"), new ArrayListStack<String>());
        System.out.println("Postfix: " + postfix);

        Calculator calculator = Calculator.getInstance();

        //menu para escoger stack


        double result = calculator.operate(postfix, new ArrayListStack<Double>()); //aca va el stack escogido en version final
        System.out.println("Result: " + result);
    }

}
