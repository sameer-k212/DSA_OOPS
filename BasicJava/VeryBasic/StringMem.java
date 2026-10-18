
public class StringMem {
    public static void main(String[] args) {
        String str = "Hello";
        String str3 = "Hello";
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println(str3 == str);
    }
}
