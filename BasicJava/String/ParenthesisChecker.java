
public class ParenthesisChecker
{
    static boolean main(String x)
    {

        int curly_brackets = 0;
        int squar_brackets = 0;
        int round_brackets = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '(') {
                round_brackets++;
            }
            if (x.charAt(i) == ')') {
                round_brackets--;
                if (round_brackets < 0) {
                    return false;
                }
            }
            if (x.charAt(i) == '[') {
                squar_brackets++;
            }
            if (x.charAt(i) == ']') {
                squar_brackets--;
                if (squar_brackets < 0) {
                    return false;
                }
            }
            if (x.charAt(i) == '{') {
                curly_brackets++;
            }
            if (x.charAt(i) == '}') {
                curly_brackets--;
                if (curly_brackets < 0)
                    return false;
            }
        }
        return curly_brackets==0&&round_brackets==0&&squar_brackets==0;
    }
    public static void main(String[] args) {
        String str="[[]])";
        boolean m= main(str);
        System.out.println(m);
    }
}
