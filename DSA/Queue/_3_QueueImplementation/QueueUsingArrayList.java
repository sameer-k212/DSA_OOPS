
import java.util.ArrayList;

public class QueueUsingArrayList {
    private ArrayList<Integer> list;
    private int front, rear;

    public QueueUsingArrayList() {
        list = new ArrayList<>();
        front = 0;
        rear = -1;
    }

    public void enqueue(int item) {
        list.add(item);
        rear++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = list.get(front);
        front++;
        if (front > rear) {
            // Reset to initial state
            list.clear();
            front = 0;
            rear = -1;
        }
        return item;
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public int size() {
        return rear - front + 1;
    }

    public static void main(String[] args) {
        QueueUsingArrayList queue = new QueueUsingArrayList();

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
