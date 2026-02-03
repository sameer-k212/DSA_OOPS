package DSA_OOPS.DSA.LinkedList._5_Two_Pointer_Problems._03_RemoveNthFromEnd;

public class RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        head = removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
