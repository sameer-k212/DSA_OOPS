package DSA_OOPS.DSA.Stack._04_Advanced_Problems._02_EvaluateExpression;

import java.util.*;

public class EvaluateExpression {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                
                if (token.equals("+")) stack.push(a + b);
                else if (token.equals("-")) stack.push(a - b);
                else if (token.equals("*")) stack.push(a * b);
                else stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("Result: " + evalRPN(tokens));
    }
}
