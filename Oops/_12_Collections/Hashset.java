package Oops._11_Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.*;
import java.util.Iterator;


// onle one data item.
public class Hashset {
    public static void main(String[] args) {
        HashSet hs = new HashSet(); // dublicat are not allowed // order of insertion not preserved.
        hs.add(2);
        hs.add(5);
        hs.add(7654);
        hs.add(3);
        hs.add(4);
        hs.add("String");
        System.out.println(hs);

        // use LinkedHashSet to preserve order of insertion.
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add(2);
        lhs.add(5);
        lhs.add(7654);
        lhs.add(2);
        lhs.add(4);
        lhs.add("ehllo");
        System.out.println(lhs);
        for (Object element : lhs) {
            System.out.println(element);
        }


        // set. with specific data type : sorted and unique.
        Set<Integer> st = new HashSet();
        st.add(4);
        st.add(4);
        st.add(5);
        st.add(0);
        st.add(3);
        System.out.println(st);
        // Iterating over the HashSet using an Iterator
        Iterator<Integer> iterator = st.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            System.out.println(element);
        }
        // Iterating over the HashSet using a for-each loop
        for (int element : st) {
            System.out.println(element);
        }

        // every thing as object
        Set st1 = new HashSet<>();
        st1.add(4);
        st1.add(4);
        st1.add(5);
        st1.add(0);
        st1.add("hello");
        System.out.println(st1);

        // iterating over hashset..
        // Iterating over the HashSet using a for-each loop
        System.out.println("Using for-each loop:");
        for (Object element : st1) {
            System.out.println(element);
        }
        // Iterating over the HashSet using an Iterator
        System.out.println("Using Iterator:");
        Iterator<Object> iterator1= st1.iterator();
        while (iterator1.hasNext()) {
            Object element = iterator1.next();
            System.out.println(element);
        }
    }
}
