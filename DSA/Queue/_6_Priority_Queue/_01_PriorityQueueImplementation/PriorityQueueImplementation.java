package DSA.Queue._6_Priority_Queue._01_PriorityQueueImplementation;

public class PriorityQueueImplementation {
    private int[] heap;
    private int size;
    private int capacity;
    
    public PriorityQueueImplementation(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }
    
    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }
    
    public void insert(int val) {
        if (size == capacity) return;
        
        heap[size] = val;
        int i = size++;
        
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    
    public int extractMin() {
        if (size == 0) return -1;
        if (size == 1) return heap[--size];
        
        int root = heap[0];
        heap[0] = heap[--size];
        minHeapify(0);
        return root;
    }
    
    private void minHeapify(int i) {
        int l = left(i), r = right(i), smallest = i;
        
        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;
        
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }
    
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public static void main(String[] args) {
        PriorityQueueImplementation pq = new PriorityQueueImplementation(10);
        pq.insert(3);
        pq.insert(1);
        pq.insert(5);
        System.out.println("Min: " + pq.extractMin());
    }
}
