
public class CircularQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int capacity;
    private int currentSize;
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = 0;
        rear = -1;
        currentSize = 0;
    }
    // Enqueue operation
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Circular Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queueArray[rear] = item;
        currentSize++;
        System.out.println("Enqueued: " + item);
    }
    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty. Cannot dequeue.");
            return -1;
        }
        int dequeuedItem = queueArray[front];
        front = (front + 1) % capacity; // Circular increment
        currentSize--;
        System.out.println("Dequeued: " + dequeuedItem);
        return dequeuedItem;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Circular Queue is empty. No front element.");
            return -1;
        }
        return queueArray[front];
    }
    // Check if queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }
    // Check if queue is full
    public boolean isFull() {
        return currentSize == capacity;
    }
    // Get size of queue
    public int size() {
        return currentSize;
    }
    public static void main(String[] args) {
        CircularQueue cQueue = new CircularQueue(5);
        cQueue.enqueue(10);
        cQueue.enqueue(20);
        cQueue.enqueue(30);
        cQueue.enqueue(40);
        cQueue.enqueue(50); // Queue is full now
        cQueue.enqueue(60); // Output: Circular Queue is full. Cannot enqueue 60
        System.out.println("Front element: " + cQueue.peek()); // Output: Front element: 10
        cQueue.dequeue(); // Output: Dequeued: 10
        cQueue.dequeue(); // Output: Dequeued: 20
        cQueue.enqueue(60); // Now there's space at index 0, so 60 goes there
        cQueue.enqueue(70); // And 70 goes to index 1
        cQueue.displayQueue(); // Helper to see queue content
// Output: Circular Queue: 60 70 30 40 50

        while (!cQueue.isEmpty()) {
            cQueue.dequeue();
        }
    }
    // Helper method to display queue elements (for debugging)
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Circular Queue: ");
        int count = 0;
        int i = front;
        while (count < currentSize) {
            System.out.print(queueArray[i] + " ");
            i = (i + 1) % capacity;
            count++;
        }
        System.out.println();
    }
}