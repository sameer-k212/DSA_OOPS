package DSA_OOPS.DSA.Stack._01_Stack_Basics._03_StackUsingLinkedList;

public class StackUsingLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    
    private Node top;
    
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }
    
    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }
    
    public int peek() {
        return (top == null) ? -1 : top.data;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
    }
}
