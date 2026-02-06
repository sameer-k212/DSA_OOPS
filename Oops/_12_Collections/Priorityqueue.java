package Oops._11_Collections;

import java.util.PriorityQueue;

public class Priorityqueue {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        boolean bool = pq.add(6); // add item at first
        System.out.println(bool);
        pq.add(2);
        System.out.println(pq);
        System.out.println("---------------------------------------");

        boolean bool1 = pq.offer(3);
        System.out.println(bool1);
        pq.offer(6);
        pq.offer(5);
        System.out.println(pq);
        System.out.println("---------------------------------------");

        System.out.println(pq.poll()); // In Java, the poll() method is part of the Queue interface and
        // is used to retrieve and remove the head (first element)
        // of the queue.

        System.out.println(pq);
        System.out.println("----------------------------------------");
    }
}
