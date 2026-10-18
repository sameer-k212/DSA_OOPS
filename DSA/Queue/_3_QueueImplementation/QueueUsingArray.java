public class QueueUsingArray {
    private int[] queue;
    private int front, rear, size, capacity;


    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int item) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(5);

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