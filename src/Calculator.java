
public class Calculator{ //falta singelton

    private static Calculator instance;

    private Calculator() {
        // constructor privado
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }
    
    public double operate(String input, Stack<Double> stack) {

        System.out.println("Input: " + input);

        for (String element : input.split(" ")) {
            

            switch (element) {
                case "+":
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);
                    break;

                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;

                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;

                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;

                case "^":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(Math.pow(a, b));
                    break;

                default:
                    stack.push(Double.parseDouble(element));
                    break;
            }
        }

        return stack.peek(); 
    }
    

    
}


