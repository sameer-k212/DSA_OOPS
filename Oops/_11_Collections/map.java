package Oops._11_Collections;

import java.util.HashMap;
import java.util.*;
// map is an interface

/*
By using the Map interface for declarations, you can easily switch between different Map implementations
(like DSA.Hashing.HashMap, TreeMap, or LinkedHashMap) without changing the rest of your code.
This promotes flexibility and code re-usability.
 */
public class map {
    public static void main(String args[]){
        // Using DSA.Hashing.HashMap
        // Declaring a map using the Map interface
        Map<String, Integer> map1 = new HashMap<>();
        // Adding key-value pairs to the map
        map1.put("apple", 2);
        map1.put("orange", 3);
        map1.put("banana", 1);

        System.out.println("TreeMap:");
        printMap(map1);


        // Switching to TreeMap
        Map<String, Integer> map2 = new TreeMap<>();
        map2.put("apple", 2);
        map2.put("orange", 3);
        map2.put("banana", 1);

        System.out.println("TreeMap:");
        printMap(map2);

        // iterating over values
        for (int count : map2.values()) {
            System.out.print(count+" ");
        }

        // Using LinkedHashMap
        Map<String, Integer> map3 = new LinkedHashMap<>();
        map3.put("apple", 2);
        map3.put("orange", 3);
        map3.put("banana", 1);

        System.out.println("LinkedHashMap:");
        printMap(map3);
    }
    public static void printMap(Map<String, Integer> map) {
        // Iterating over the map entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
           System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}

