package DSA_OOPS.DSA.LinkedList._4_Basic_Operations._03_MergeKSortedLists;

import java.util.*;

public class MergeKSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode head : lists) {
            if (head != null) pq.offer(head);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        
        ListNode[] lists = {l1, l2, l3};
        ListNode result = mergeKLists(lists);
        
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
