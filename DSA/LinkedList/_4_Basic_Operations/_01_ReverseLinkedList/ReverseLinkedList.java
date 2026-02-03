package DSA_OOPS.DSA.LinkedList._4_Basic_Operations._01_ReverseLinkedList;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    public static ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        head = reverseIterative(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
