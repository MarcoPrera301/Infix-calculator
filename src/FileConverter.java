
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;


public class FileConverter
{
    public static ArrayList<String> parseFile(String filepath) 
    {
        ArrayList<String> elements = new ArrayList<>();

        try {
            String content = Files.readString(Paths.get(filepath));
            String[] lines = content.split("\n");

            for (String line : lines) {
                if (!line.isEmpty()) {
                    elements.add(line.trim());
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo.");
        }

        return elements;
    }

    public static String infixToPostfix(ArrayList<String> elements, Stack<String> stack) 
    {
         ArrayList<String> tokens = new ArrayList<>();
        for (String expr : elements) {
            StringBuilder num = new StringBuilder();
            for (char c : expr.toCharArray()) {
                if (Character.isDigit(c) || c == '.') {
                    num.append(c);
                } else {
                    if (num.length() > 0) { tokens.add(num.toString()); num.setLength(0); }
                    if (c != ' ') tokens.add(String.valueOf(c));
                }
            }
            if (num.length() > 0) tokens.add(num.toString());
        }
        String postfix = "";

        for (String token : tokens) 
            {
            if (isNumber(token)) 
            {
                postfix += token + " ";
            }
            else if (token.equals("(")) 
            {
                stack.push(token);
            }
            else if (token.equals(")")) //se agregan todos los operandos del stack al string hasta encontrar un "("
            {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix += stack.pop() + " ";
                }
                stack.pop();
            }
            else 
            {
                while (!stack.isEmpty() && !stack.peek().equals("(") && hierarchy(token) <= hierarchy(stack.peek())) 
                {
                    postfix += stack.pop() + " ";
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) 
        {
            postfix += stack.pop() + " ";
        }
        return postfix.trim();
    }

    private static boolean isNumber(String token) 
    {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int hierarchy(String operator) 
    {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
            default:
                return 0;
        }
    }


}