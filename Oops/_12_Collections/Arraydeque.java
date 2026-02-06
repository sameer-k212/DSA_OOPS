package Oops._11_Collections;

import java.util.ArrayDeque;

public class Arraydeque {
    public static void main(String[] args) {
        // adding elements.
        ArrayDeque ad1 = new ArrayDeque();
        ad1.add(4); // by default at last
        ad1.add(5);
        ad1.add("true");
        ad1.add("true");

        ad1.offer("sam"); // In Java's ArrayDeque class, both offer() and offerLast() functions
                             // are used to insert an element at the end of the deque.
        System.out.println(ad1); // heterogeneous data item.
        System.out.println("***************************");

        // adding at first.
        ArrayDeque ad = new ArrayDeque();
        ad.addFirst(10);
        ad.addFirst("sameer");
        //ad.addAll(ad1); // [sameer, 10, 4, 5, true]
        ad.add(ad1);   //  [sameer, 10, [4, 5, true]]
//        System.out.println(ad);

        // index base accessing is not allowed.

        // sorting with inbuilt function allowed only for same type of data contained ArrayList.

    }
}
