package Oops._6_Static;

import java.util.Stack;

public class ReversePolish {
    public static String reversePolish(String str[]){
        Stack<String> st = new Stack<String>();
        String operator = "+-*/";
        for(int i = 0 ; i < str.length; i++){
            if(!operator.contains(str[i])){
                st.push(str[i]);
            }else{
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                switch(str[i]){                    // switch string statement is only available
                                                   // from JDK 1.7
                    case "+":
                        st.push(String.valueOf(a+b));
                        break;
                    case "-":
                        st.push(String.valueOf(b-a)) ;
                        break;
                    case "*":
                        st.push(String.valueOf(a*b)) ;
                        break;
                    case "/":
                        st.push(String.valueOf(b / a)) ;
                        break;
                }
            }
        }
        return st.pop();
    }
    // Solution for Switch ;
    public static void revPol(String str[]){
        Stack<String> st = new Stack<String>();
        String operator = "+-*/";
        for(int i = 0 ; i < str.length; i++){
            if(!operator.contains(str[i])){
                st.push(str[i]);
            }else{
                int a = Integer.valueOf(st.pop());
                int b = Integer.valueOf(st.pop());
                int index = operator.indexOf(str[i]);
                switch(index){                    // switch string statement is only available
                    // from JDK 1.7
                    case 0:
                        st.push(String.valueOf(a+b));
                        break;
                    case 1:
                        st.push(String.valueOf(b-a)) ;
                        break;
                    case 2:
                        st.push(String.valueOf(a*b)) ;
                        break;
                    case 3:
                        st.push(String.valueOf(b / a)) ;
                        break;
                }
            }
        }
        System.out.println(st.pop());
    }
    // naive approach


    public static void main(String[] args) {
        System.out.println(Integer.valueOf(reversePolish(new String[]{"2","1","+","3","*"})));
        revPol(new String[]{"2","1","+","3","*"});
    }
}



