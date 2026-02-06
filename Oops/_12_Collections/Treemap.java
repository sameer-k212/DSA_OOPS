package Oops._11_Collections;

import java.util.TreeMap;

public class Treemap {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap(); // can not add null key ; // value can be null.
        tm.put(2,"sam");          // order of insertion not preserve .
        tm.put(1,"rohit");
        tm.put(4,"papa");
        tm.put(3, "ramesh");
        tm.put(4,null);

        System.out.println(tm);
    }
}
