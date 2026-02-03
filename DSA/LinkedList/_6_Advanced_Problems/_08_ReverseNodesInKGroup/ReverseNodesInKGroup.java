package DSA_OOPS.DSA.LinkedList._6_Advanced_Problems._08_ReverseNodesInKGroup;

public class ReverseNodesInKGroup {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        if (count == k) {
            curr = reverseKGroup(curr, k);
            
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            head = curr;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        head = reverseKGroup(head, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
