package Oops._11_Collections;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Enumeration;
// key value pair
public class HashTABLE {
    
    public static void main(String[] args) {
        java.util.Hashtable ht = new java.util.Hashtable(); // can not put null key or value;
        ht.put(3,"Rohit");
        ht.put(2,"Sameer");
        ht.put("name","Sameer");
        ht.put(4,"Kajal");
        ht.put("my name","sameer kushwaha");
        System.out.println(ht);



        // ................................................
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("One", 1);
        hashtable.put("Two", 2);
        hashtable.put("Three", 3);

        Iterator<Entry<String, Integer>> iterator = hashtable.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Enumeration<String> keys = hashtable.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            Integer value = hashtable.get(key);
            System.out.println(key + ": " + value);
        }
    }
}
