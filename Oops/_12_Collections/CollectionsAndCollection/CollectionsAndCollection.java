package Oops._11_Collections.CollectionsAndCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/** Collections : This class consists exclusively of static methods that operate on or
 *  return collections. It contains polymorphic algorithms that operate on collections,
 *  "wrappers", which return a new collection backed by a specified collection, and a few
 *  other odds and ends.
 *-----------------------------------------------------------------------------------------
 *  Collection: The root interface in the collection hierarchy. A collection represents a
 *  group of objects, known as its elements. Some collections allow duplicate elements and
 *  others do not. Some are ordered, and others are unordered.
 *  it provides implementations of more specific subinterfaces like Set and List
 *
 *  Example : The Collections.sort() method requires a List<T>, not just a Collection<T>.
 */

public class CollectionsAndCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList();
        c.add(8);
        c.add(4);
        c.add(7);
        System.out.println(c);
        
//        Collections.sort(c); // ❌ ERROR: sort(Collection<T>) is undefined
        System.out.println(c);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(5);
        Collections.sort(list);
        System.out.println(list);

    }
}
