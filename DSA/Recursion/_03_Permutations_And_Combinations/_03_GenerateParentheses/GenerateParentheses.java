
import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        generateParentheses(3, result, "", 0, 0);
        System.out.println("All valid parentheses combinations for n=3: " + result);
        
        result.clear();
        generateParentheses(2, result, "", 0, 0);
        System.out.println("All valid parentheses combinations for n=2: " + result);
    }

    public static void generateParentheses(int n, List<String> result, String current, int open, int close) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generateParentheses(n, result, current + "(", open + 1, close);
        }

        if (close < open) {
            generateParentheses(n, result, current + ")", open, close + 1);
        }
    }
}