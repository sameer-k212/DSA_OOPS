package DSA.Array_Restructured._05_Intersection_And_Merging._03_MergeAlternately;

public class MergeAlternately {
    public static String merge(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        
        while (i < s1.length() && j < s2.length()) {
            result.append(s1.charAt(i++));
            result.append(s2.charAt(j++));
        }
        
        while (i < s1.length()) result.append(s1.charAt(i++));
        while (j < s2.length()) result.append(s2.charAt(j++));
        
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(merge("abc", "pqr"));  // apbqcr
        System.out.println(merge("ab", "pqrs"));  // apbqrs
    }
}
