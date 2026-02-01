package DSA.Hashing_Restructured._01_Basics._02_HashSetImplementation;

import java.util.*;

public class HashSetImplementation {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        
        // Add elements
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1); // Duplicate, won't be added
        
        System.out.println("Set: " + set); // [1, 2, 3]
        
        // Check if element exists
        System.out.println("Contains 2: " + set.contains(2)); // true
        System.out.println("Contains 5: " + set.contains(5)); // false
        
        // Remove element
        set.remove(2);
        System.out.println("After removing 2: " + set); // [1, 3]
        
        // Size
        System.out.println("Size: " + set.size()); // 2
        
        // Iterate
        for (int num : set) {
            System.out.print(num + " ");
        }
    }
}
