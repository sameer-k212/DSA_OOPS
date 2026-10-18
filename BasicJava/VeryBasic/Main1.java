
import java.util.*;
class Main1 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        rem(s, 0, 0, "");
        System.out.println(rep(s));
    }
    private static void rem(String s, int i, int count, String k) {
        if(i >= s.length()){
            System.out.println(count);
            System.out.println(k);
            return;
        }
        char c = s.charAt(i);
        if(i < s.length() - 1 && s.substring(i, i + 2).equals("hi") && (i >= s.length() - 2 || s.charAt(i + 2) != 't')){
            rem(s, i + 2, count + 1, k);
        }
        else{
            rem(s, i + 1, count, k + c);
        }
    }    private static String rep(String s) {
        return s.replaceAll("hi", "bye");
    }
}
