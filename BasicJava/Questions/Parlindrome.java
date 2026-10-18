
public class Parlindrome {
    static int isPalindrome(String S) {
        String s="abba";
        String str="";
        for(int i=s.length()-1;i>=0;i--)
        {
            str=str+s.charAt(i);
        }
        if(s.equals(str))
        {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static void main(String[] args) {
     String arg="abba";
     int m=isPalindrome(arg);
        System.out.println(m);
    }
}









