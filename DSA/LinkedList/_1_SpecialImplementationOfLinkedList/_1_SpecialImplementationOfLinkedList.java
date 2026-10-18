
class Node<T>{
    T val;
    Node next;
    Node(T val){
        this.val = val;
        this.next = null;
    }
}

class LinkedList<T>{
    private Node head;

    public LinkedList(){
        head = null;
    }

    public void addLast(int val){
        Node newNode = new Node(val);

        if(head == null){
            newNode.next = head;
            head = newNode;
        }else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    public void display(){
        Node curr = head;

        while(curr != null){
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}


public class _1_SpecialImplementationOfLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.display();
    }
}
