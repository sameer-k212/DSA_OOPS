package POD;

import java.util.Arrays;

public class $3_2138 {
    public static String[] divideString(String s, int k, char fill) {
        String arr[] = new String[s.length() % k == 0 ? s.length() / k : (s.length() / k) + 1];

        int a = 0;
        for (int i = 0; i <= s.length() - k;) {
            StringBuilder sb = new StringBuilder();
            int j = i + k;
            while (i < j && i < s.length()) {
                sb.append(s.charAt(i));
                i++;
            }
            arr[a++] = sb.toString();
        }

        String last = s.substring(s.length() - s.length() % k);
        if (last.length() != 0) {
            while (last.length() != k) {
                last += fill;
            }
            arr[arr.length-1] = last;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("a", 1, 'b')));
    }
}
