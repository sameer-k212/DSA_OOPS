package DSA_OOPS.DSA.Queue._5_Queue_Problems._01_ImplementStackUsingQueues;

import java.util.*;

public class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
    
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
    }
}
