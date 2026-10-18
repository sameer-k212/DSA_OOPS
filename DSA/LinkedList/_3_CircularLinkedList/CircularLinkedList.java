

class CircularNode {
    int data;
    CircularNode next;
    public CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}
public class CircularLinkedList {
    CircularNode head;
    CircularNode tail; // Keep track of tail for easier adding to end
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }
    // Method to add a new node to the end of the list
    public void add(int data) {
        CircularNode newNode = new CircularNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;

            newNode.next = head; // Point to itself for single node list
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Link new tail to head
        }
    }
    // Method to delete a node with a given value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
// If only one node and it's the one to be deleted
        if (head == tail && head.data == data) {
            head = null;
            tail = null;
            return;
        }
// If head needs to be deleted
        if (head.data == data) {
            head = head.next;
            tail.next = head; // Update tail's next to new head
            return;
        }
        CircularNode current = head;
        CircularNode prev = null;
// Traverse to find the node to delete
        while (current.next != head && current.data != data) {
            prev = current;
            current = current.next;
        }
// If node found and it's not the head (already handled)
        if (current.data == data) {
            prev.next = current.next;
            if (current == tail) { // If deleting the tail
                tail = prev;
            }

        } else {
            System.out.println(data + " not found in the list.");
        }
    }

    // Method to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        CircularNode current = head;
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(points back to " + head.data + ")");
    }
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(10);
        cll.add(20);
        cll.add(30);
        cll.display(); // Output: Circular Linked List: 10 -> 20 -> 30 -> (points back to 10)
        cll.delete(20);
        cll.display(); // Output: Circular Linked List: 10 -> 30 -> (points back to 10)
        cll.delete(10);
        cll.display(); // Output: Circular Linked List: 30 -> (points back to 30)
        cll.delete(30);
        cll.display(); // Output: List is empty.
    }
}