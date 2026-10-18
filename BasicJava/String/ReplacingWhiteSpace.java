
public class ReplacingWhiteSpace {
    public static void main(String[] args) {
        String str = " Hello My   Name Is     Sameer  ";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str = str.replace(" ","");
            }
        }
        System.out.println(str);
    }
}
