package DSA_OOPS.DSA.LinkedList._6_Advanced_Problems._05_CopyListWithRandomPointer;

import java.util.*;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next, random;
        Node(int val) { this.val = val; }
    }
    
    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;
        while (curr != null) {
            copyCurr.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next;
        
        Node copy = copyRandomList(head);
        System.out.println("Deep copy created successfully");
    }
}
