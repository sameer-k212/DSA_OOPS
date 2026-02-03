package DSA_OOPS.DSA.LinkedList._6_Advanced_Problems._04_RotateList;

public class RotateList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        ListNode curr = head;
        int len = 1;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        
        curr.next = head;
        k = k % len;
        int stepsToNewHead = len - k;
        
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        head = rotateRight(head, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
