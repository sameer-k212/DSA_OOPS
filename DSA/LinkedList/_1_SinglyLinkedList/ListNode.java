import java.util.*;
class ListNode{

    private ListNode head;
    private ListNode next;
    private ListNode tail;
    int val;
    ListNode(){
    }

    ListNode(int val){
        this.val = val;
        this.next = next;
    }

    public void addFirst(int val){
        if(head == null){
            head = new ListNode(val);
            tail = new ListNode(val);
        }else{
            ListNode new_node = new ListNode(val);
            new_node.next = head;
            head = new_node;
        }
    }
    public void addLast(int data){
        if(head == null){
            addFirst(data);
        }else{
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            ListNode new_node = new ListNode(data);
            temp.next = new_node;
            tail = new_node;
            // Or
            // tail.next = new_node;
            // tail = new_node;
        }
    }
    public void addAtPosition(int data, int position) {
        int size = 0;
        ListNode temp = head; // we have take temp for only size calculation;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (position < 1 || position > size) {
            System.out.println("Invalid position.");
            return;
        }
        ListNode new_node = new ListNode(data);
        if (position == 1) {
            new_node.next = head;
            head = new_node;
        } else {
            temp = head;
            for (int i = 1; i <= position - 2; i++) {
                temp = temp.next;
            }
            new_node.next = temp.next;
            temp.next = new_node;
        }
    }

    // removal of elements.
    public void removeFirst(){
        ListNode new_node = head;
        head = head.next;
        new_node.next = null;
    }
    public void removeLast(){
        ListNode new_node = head;
        while(new_node.next.next != null){
            new_node = new_node.next;
        }
        tail = new_node;
        new_node.next = null;
    }
    public void removeAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty. No element to remove.");
            return;
        }
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (position < 1 || position > size) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            removeFirst();
        } else if (position == size) {
            removeLast();
        } else {
            temp = head;
            for (int i = 0; i < position - 2; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
    public void print(){
        ListNode temp = head;
        while(temp != null){
            if(temp.next != null)
                System.out.print(temp.val + "->");
            else{
                System.out.print(temp.val);
            }
            temp = temp.next;
        }
        System.out.println();
    }










    public int solution(ListNode head){
        // code here








        return head.val;
    }




    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ListNode head = new ListNode();
        ListNode curr = head;
//        System.out.print("Enter the no of elements you want: ");
        int n = 8;
        System.out.print("Enter the elements of ListNode: ");
        for(int i = 0; i < n; i++){
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        head = head.next;
        int  temp = head.solution(head);
//        while(temp != null){
//            if(temp.next != null)
//                System.out.print(temp.val + "->");
//            else{
//                System.out.print(temp.val);
//            }
//            temp = temp.next;
//        }
        System.out.println(temp);
    }
}

