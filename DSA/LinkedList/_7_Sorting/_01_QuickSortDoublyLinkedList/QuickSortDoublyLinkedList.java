package DSA_OOPS.DSA.LinkedList._7_Sorting._01_QuickSortDoublyLinkedList;

public class QuickSortDoublyLinkedList {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }
    
    public static Node partition(Node low, Node high) {
        int pivot = high.data;
        Node i = low.prev;
        
        for (Node j = low; j != high; j = j.next) {
            if (j.data <= pivot) {
                i = (i == null) ? low : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i == null) ? low : i.next;
        int temp = i.data;
        i.data = high.data;
        high.data = temp;
        return i;
    }
    
    public static void quickSort(Node low, Node high) {
        if (high != null && low != high && low != high.next) {
            Node pivot = partition(low, high);
            quickSort(low, pivot.prev);
            quickSort(pivot.next, high);
        }
    }
    
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(8);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(1);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.prev = head.next.next.next;
        
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        
        quickSort(head, tail);
        
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
