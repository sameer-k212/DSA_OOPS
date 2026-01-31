package DSA.Stack_Restructured._01_Stack_Basics._01_StackImplementation;

public class StackImplementation {
    private int[] arr;
    private int top;
    private int capacity;
    
    public StackImplementation(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }
    
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
    
    public int peek() {
        if (top == -1) return -1;
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackImplementation stack = new StackImplementation(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.peek());
    }
}
