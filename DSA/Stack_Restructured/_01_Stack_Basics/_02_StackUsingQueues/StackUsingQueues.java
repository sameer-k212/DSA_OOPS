package DSA.Stack_Restructured._01_Stack_Basics._02_StackUsingQueues;

import java.util.*;

public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    
    // Push: O(n)
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Pop: O(1)
    public int pop() {
        if (q1.isEmpty()) return -1;
        return q1.remove();
    }
    
    // Top: O(1)
    public int top() {
        if (q1.isEmpty()) return -1;
        return q1.peek();
    }
    
    // Empty: O(1)
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.top());
    }
}
