
public class Calculator{ //falta singelton

    StackA<Double> stack;
    
    public Calculator() {
        //stack = new Stack<Double>();    } aca va el stack escogido
    
    public double operate(String input) {

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


