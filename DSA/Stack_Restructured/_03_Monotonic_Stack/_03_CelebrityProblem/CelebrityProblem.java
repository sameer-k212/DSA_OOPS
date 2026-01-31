package DSA.Stack_Restructured._03_Monotonic_Stack._03_CelebrityProblem;

import java.util.*;

public class CelebrityProblem {
    public static int findCelebrity(int[][] matrix) {
        Stack<Integer> stack = new Stack<>();
        
        // Push all people
        for (int i = 0; i < matrix.length; i++) {
            stack.push(i);
        }
        
        // Find potential celebrity
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            
            if (matrix[a][b] == 1) {
                stack.push(b); // a knows b, so a can't be celebrity
            } else {
                stack.push(a); // a doesn't know b, so b can't be celebrity
            }
        }
        
        int candidate = stack.pop();
        
        // Verify candidate
        for (int i = 0; i < matrix.length; i++) {
            if (i != candidate) {
                if (matrix[candidate][i] == 1 || matrix[i][candidate] == 0) {
                    return -1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };
        System.out.println("Celebrity: " + findCelebrity(matrix));
    }
}
