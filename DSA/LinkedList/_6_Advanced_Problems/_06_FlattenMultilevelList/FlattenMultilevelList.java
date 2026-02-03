package DSA_OOPS.DSA.LinkedList._6_Advanced_Problems._06_FlattenMultilevelList;

public class FlattenMultilevelList {
    static class Node {
        int val;
        Node prev, next, child;
        Node(int val) { this.val = val; }
    }
    
    public static Node flatten(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node child = flatten(curr.child);
                
                curr.next = child;
                child.prev = curr;
                curr.child = null;
                
                while (curr.next != null) {
                    curr = curr.next;
                }
                
                if (next != null) {
                    curr.next = next;
                    next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        
        head.next.child = new Node(7);
        head.next.child.next = new Node(8);
        head.next.child.next.prev = head.next.child;
        
        head = flatten(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
