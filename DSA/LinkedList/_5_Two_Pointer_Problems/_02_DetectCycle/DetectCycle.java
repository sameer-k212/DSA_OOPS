package DSA_OOPS.DSA.LinkedList._5_Two_Pointer_Problems._02_DetectCycle;

public class DetectCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) return true;
        }
        return false;
    }
    
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        
        System.out.println("Has cycle: " + hasCycle(head));
        System.out.println("Cycle starts at: " + detectCycle(head).val);
    }
}
