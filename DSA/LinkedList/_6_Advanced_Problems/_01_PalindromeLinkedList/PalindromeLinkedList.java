package DSA_OOPS.DSA.LinkedList._6_Advanced_Problems._01_PalindromeLinkedList;

public class PalindromeLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode secondHalf = reverse(slow);
        ListNode firstHalf = head;
        
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        
        System.out.println("Is palindrome: " + isPalindrome(head));
    }
}
