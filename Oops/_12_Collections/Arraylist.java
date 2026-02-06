package Oops._11_Collections;
import java.util.*;
// all collections store data as object.
public class Arraylist {
    public static void main(String[] args) {
     // adding elements.
        ArrayList al1 = new ArrayList();
        al1.add(4); // by default at last
        al1.add(5);
        al1.add("true");
        System.out.println(al1);
        System.out.println("***************************");

     // adding at first.
        ArrayList al = new ArrayList();
        al.addFirst(10);
        al.addFirst("sameer");
        //al.addAll(al1); // [sameer, 10, 4, 5, true]
        al.add(al1);   //  [sameer, 10, [4, 5, true]]
        System.out.println(al);

     // adding at any Index and given position should be in range otherwise runtime exception
        al.add(1,0);
        System.out.println(al);

     // sorting with inbuilt function allowed only for same type of data contained ArrayList.
        // for integers.
        ArrayList b = new ArrayList();
        b.add(1);
        // b.add(0.9); it will cause error beacue it is not integer.
        Collections.sort(b);
        System.out.println(b);
        b.clear();

        // for char
        b.add('a');
        b.add('e');
        b.add('b');
        Collections.sort(b);
        System.out.println(b);
        b.clear();

        // for strings
        b.add("Sameer");
        b.add("sameer");
        b.add("sAmeer");
        b.add("SAmeer");
        b.add("SAMEER");
        Collections.sort(b);
        System.out.println(b);
        b.clear();

        // for special char
        b.add('*');
        b.add('|');
        b.add('?');
        b.add('/');
        b.add('%');
        b.add('#');
        Collections.sort(b);
        System.out.println(b);
        b.clear();


        // accessing element by index
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(4);
        list.add(13);
        list.add(18);
        System.out.println(list.get(3));



        ArrayList al2 = new ArrayList();
        al2.add(" ");
        al2.add(' ');
        al2.add('i');
        System.out.println(al2);



        // Using Generics
        AbstractList<Integer> arrayList = new ArrayList<>();  // AbstractList abstract class
        List<Integer> list1 = new ArrayList<>();              // List interface


    }
}
