package DSA.Stack_Restructured._02_Matching_Problems._02_RedundantBrackets;

import java.util.*;

public class RedundantBrackets {
    public static boolean hasRedundant(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                boolean hasOperator = false;
                while (stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }
                if (!hasOperator) return true;
                stack.pop(); // Remove '('
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasRedundant("((a+b))"));    // true
        System.out.println(hasRedundant("(a+(b*c))"));  // false
    }
}
