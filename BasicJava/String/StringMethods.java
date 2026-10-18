
import java.util.*;

public class StringMethods {
    public static void main(String args[])
    {
        // # Immutable Strings:

        String name="Sameer";

        // Upper case:
        System.out.println(name.toUpperCase());

        // Lower case:
        System.out.println(name.toLowerCase());

        // Concat
        System.out.println(name.concat("Kushwaha")); // append is not possible here

        // # Mutable Strings:

        StringBuilder name1=new StringBuilder("kajal");
        StringBuffer name2=new StringBuffer("kushwaha");

        // Append:
        System.out.println(name1.append("girl"));   // concat is not possible.
        System.out.println(name2.append("girl"));
        System.out.println(name1.substring(1));
        System.out.println(name1.charAt(0)); // k
        System.out.println(name1.indexOf("a")); // 1

        // lastIndexOf(str:)
        int Index= name1.lastIndexOf("a"); // 3
        System.out.println(Index);

        // codePointAt()
        String sb="Sameer";
        int m= sb.codePointAt(1); // return the unicode of char at given index.
        System.out.println(m);

        // codePointBefore()
        sb="sameer";
        m=sb.codePointBefore(1);
        System.out.println(m);

        // codePoints().sum()
        sb="Sameer";
        m=sb.codePoints().sum();
        System.out.println(m);

        // codePointCount()
        sb="Sameer";
        m=sb.codePointCount(4,6); // 6-->> 5 index tak 6 excluded.
        System.out.println(m);

        // compareTo()
        sb="Sbmeer";
        System.out.println(sb.compareTo("Sa"));// compare char of
                                              // Strings lexicographycally.

        // concate()

        sb="Sameer";
        System.out.println(sb.concat("same"));

        // lenght()
        sb="Sameer";
        System.out.println(sb.length());

        // indexOf()
        sb="Sameer kushwaha";
        System.out.println(sb.indexOf("kush"));

        // repeat(int n)
        sb=sb.repeat(4);
        System.out.println(sb);

        // split(str:)    always return a array of string.
        String[] st=sb.split("");
        System.out.println(st);

        //
        sb="Sameer";
        int n=9;
        System.out.println(sb+n); // String type.

        // BasicJava.Math.max()
        System.out.println(Math.max(5,4));

        //BasicJava.Math.sqrt()
        System.out.println(Math.sqrt(1.2));

        // BasicJava.Math.abs()
        System.out.println(Math.abs(-6));

        // BasicJava.Math.random()
        System.out.println(Math.random());

        // str.subString()
        String str="Sameer";
        System.out.println(str.substring(2));
        System.out.println(str.substring(1,4));

        //str.indexOf().
        System.out.println(str.indexOf("S"));
        System.out.println(str.indexOf(2));;

        // str.lastIndexOf()
        System.out.println(str.lastIndexOf("r"));
        System.out.println(str.lastIndexOf("e"));

        // replace() method.
        StringBuilder sam = new StringBuilder("Sameer");
        sam.replace(0,2,"");
        System.out.println(sam);












    }
}









