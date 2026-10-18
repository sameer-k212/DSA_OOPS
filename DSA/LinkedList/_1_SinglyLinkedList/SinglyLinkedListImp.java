class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class SinglyLinkedListImp {
    Node head; // Head of the list
    public SinglyLinkedListImp() {
        this.head = null;
    }
    // Method to add a new node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;

        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // Method to insert a new node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    // Method to delete a node with a given value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head.data == data) {
            head = head.next; // If head is the node to be deleted
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next; // Skip the node to be deleted
        } else {
            System.out.println(data + " not found in the list.");
        }
    }
    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");

            return;
        }
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        SinglyLinkedListImp list = new SinglyLinkedListImp();
        list.add(10);
        list.add(20);
        list.add(30);
        list.display(); // Output: Linked List: 10 -> 20 -> 30 -> null
        list.addFirst(5);
        list.display(); // Output: Linked List: 5 -> 10 -> 20 -> 30 -> null
        list.delete(20);
        list.display(); // Output: Linked List: 5 -> 10 -> 30 -> null
        list.delete(5);
        list.display(); // Output: Linked List: 10 -> 30 -> null
        list.delete(100); // Output: 100 not found in the list.
    }
}