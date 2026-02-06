package Oops._6_Static;

import java.util.*;
public class SimplifyPath {
    public static void main(String[] args) {
        String  str = "/home/user/Documents/../Pictures";
        str = str.replace("//","/");
        String arr[] = str.split("/");
        Stack<String> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!st.isEmpty() && arr[i].equals("..")) {
                st.pop();
            }else if (!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals("..")) {
                st.push(arr[i]);
            }
        }
        System.out.println(st);

        String ans = "";
        while (!st.isEmpty()) {
            ans = "/" + st.pop() + ans;
        }
        if(ans.isEmpty())
            ans = "/";
        System.out.println(ans);
    }
}
