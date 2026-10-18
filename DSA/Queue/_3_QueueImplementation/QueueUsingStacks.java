
import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(T item) {
        stack1.push(item);
    }

    // Dequeue operation
    public T dequeue() {
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

        // Enqueue items
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue items
        System.out.println(queue.dequeue()); // Output: 1
        System.out.println(queue.dequeue()); // Output: 2

        // Check the size of the queue
        System.out.println("Size: " + queue.size()); // Output: 1
    }
}

