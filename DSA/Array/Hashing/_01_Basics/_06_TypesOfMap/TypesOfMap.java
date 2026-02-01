package DSA.Array.Hashing._01_Basics._06_TypesOfMap;

import java.util.*;

public class TypesOfMap {
    public static void main(String[] args) {
        // HashMap - Unordered
        HashMap<Integer, String> map = new HashMap<>();
        map.put(4, "Priya");
        map.put(2, "Shivam");
        map.put(9, "Siddharth");
        map.put(1, "Ram");
        System.out.println("HashMap (unordered): " + map);

        // LinkedHashMap - Insertion order preserved
        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(4, "Priya");
        map1.put(2, "Shivam");
        map1.put(9, "Siddharth");
        map1.put(1, "Ram");
        System.out.println("LinkedHashMap (insertion order): " + map1);

        // TreeMap - Sorted by key
        TreeMap<Integer, String> map2 = new TreeMap<>();
        map2.put(4, "Priya");
        map2.put(2, "Shivam");
        map2.put(9, "Siddharth");
        map2.put(1, "Ram");
        map2.put(10, "Rama");
        map2.put(5, "Sham");
        System.out.println("TreeMap (sorted by key): " + map2);
    }
}
