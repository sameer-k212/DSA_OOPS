

class DoublyNode {
    int data;
    DoublyNode prev;
    DoublyNode next;
    public DoublyNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }
    // Method to add a new node at the end
    public void add(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    // Method to add a new node at the beginning
    public void addFirst(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    // Method to delete a node with a given value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        DoublyNode current = head;
// Case 1: Node to be deleted is the head
        if (current.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else { // List becomes empty
                tail = null;
            }
            return;
        }
// Traverse to find the node
        while (current != null && current.data != data) {
            current = current.next;
        }
// Case 2: Node found (not head)
        if (current != null) {
            if (current.next != null) {
                current.next.prev = current.prev;
            } else { // Node to be deleted is the tail
                tail = current.prev;
            }
            current.prev.next = current.next;
        } else {
            System.out.println(data + " not found in the list.");
        }
    }
    // Method to display the list forward
    public void displayForward() {
        if (head == null) {

            System.out.println("List is empty.");
            return;
        }
        DoublyNode current = head;
        System.out.print("Doubly Linked List (Forward): ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    // Method to display the list backward
    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        DoublyNode current = tail;
        System.out.print("Doubly Linked List (Backward): ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(10);
        dll.add(20);
        dll.add(30);
        dll.displayForward(); // Output: Doubly Linked List (Forward): 10 <-> 20 <-> 30 <-> null
        dll.displayBackward(); // Output: Doubly Linked List (Backward): 30 <-> 20 <-> 10 <-> null
        dll.addFirst(5);
        dll.displayForward(); // Output: Doubly Linked List (Forward): 5 <-> 10 <-> 20 <-> 30 <-> null

        dll.delete(20);
        dll.displayForward(); // Output: Doubly Linked List (Forward): 5 <-> 10 <-> 30 <-> null
        dll.delete(5);
        dll.displayForward(); // Output: Doubly Linked List (Forward): 10 <-> 30 <-> null

        dll.delete(30);
        dll.displayForward(); // Output: Doubly Linked List (Forward): 10 <-> null
        dll.displayBackward(); // Output: Doubly Linked List (Backward): 10 <-> null
    }
}