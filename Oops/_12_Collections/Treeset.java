package Oops._11_Collections;

import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(); // order of insertion is not preserve. // data in sorted order.
        ts.add(1);
        ts.add(3);
        ts.add(5);
        ts.add(2);
        ts.add(4);
//        ts.add("PAPA");
        System.out.println(ts);
    }
}
