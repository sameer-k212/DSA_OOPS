package Oops._11_Collections;
import java.util.HashMap;
import java.util.*;
import java.util.Map.*;
import java.util.TreeMap;

import java.util.Iterator;
// DSA.Hashing.HashMap is Class : key value pair
public class Hashmap {
    public static void main(String[] args) {
        System.out.println("1..........................................");
        HashMap hm1 = new HashMap();
        hm1.put("key1", "value1"); // Valid
        hm1.put(1, "value2"); // Also valid, but may cause issues later
        hm1.put(null,null);
        String value = (String) hm1.get("key1"); // Requires a cast
        String value2 = (String) hm1.get(1);
        System.out.println(value);
        System.out.println(value2);
        System.out.println(hm1);

        // another implementation.
        System.out.println("2.........................................");
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("key1", "value1"); // Valid
//        hm.put(1, "value1"); // Compile-time error
        String value1 = hm.get("key1");
        hm.put(null,null);
        System.out.println(value1);
        System.out.println(hm);


        // Declaring a DSA.Hashing.HashMap
        System.out.println("3..................................");
        HashMap<String, Integer> hashmap1 = new HashMap<>();
//    or     var hashMap = new DSA.Hashing.HashMap<String, Integer>();
        // Adding key-value pairs to the DSA.Hashing.HashMap
        hashmap1.put("apple", 2);
        hashmap1.put("orange", 3);
        hashmap1.put("banana", 1);


        System.out.println("4............................................");



        // iterating over hashmap..
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);

        // using for each loop.
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // using iterator..
        Iterator<Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Iterating over the keys in the DSA.Hashing.HashMap
        for (String key : hashmap1.keySet()) {
            System.out.println("Key: " + key);
        }
        // Iterating over the keys in the DSA.Hashing.HashMap using iterator
        Iterator<String> iterator1 = hashmap1.keySet().iterator();
        while (iterator1.hasNext()) {
            String key = iterator1.next();
            System.out.println("Key: " + key);
        }


        // sorting according to key and Iterating over the DSA.Hashing.HashMap entries
        Map<String, Integer> sortedMap = new TreeMap<>(hashmap1);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }



        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(null, null);
        map.put(null, 1);    // arey dublicate kye ho hi nhi sakte agar try bhi karoge
                             // toh key update ho kayega previous wala.
        System.out.println(map);
    }
}
