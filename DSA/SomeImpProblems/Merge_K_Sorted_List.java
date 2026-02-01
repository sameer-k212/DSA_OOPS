package DSA.SomeImpProblems;
import java.util.*;
public class Merge_K_Sorted_List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read K and N
        int K = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Create a priority queue (min-heap)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // Read the K sorted linked lists
        List<ListNode> lists = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            ListNode head = null;
            ListNode current = null;
            for (int j = 0; j < N; j++) {
                int value = sc.nextInt();
                if (head == null) {
                    head = new ListNode(value);
                    current = head;
                } else {
                    current.next = new ListNode(value);
                    current = current.next;
                }
            }
            lists.add(head); // Store the head of each linked list
        }

        // Add the first node of each list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }

        // Resultant sorted linked list
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        // Merge the K sorted linked lists
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll(); // Get the smallest node
            tail.next = minNode; // Append to the merged list
            tail = tail.next; // Move the tail pointer

            if (minNode.next != null) {
                minHeap.add(minNode.next); // Add the next node from the same list to the min-heap
            }
        }

        // Print the merged sorted linked list
        ListNode current = dummyHead.next; // Skip the dummy head
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
