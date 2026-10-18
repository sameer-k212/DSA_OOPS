import java.util.*;
import java.lang.*;
public class SpreadSheet{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("Enter the nums of string you want to take:");
        int n = sc.nextInt();
        String arg[] = new String[n];
        System.out.println("Enter your string sir"+n+" times:");
        for(int i=0;i<n;i++){
            arg[i] = sc.next();
        }
        for(int i=0;i<n;i++){
            spreadSheet(arg[i],str);
        }
    }
    static void spreadSheet(String str1, String str){

        char ch1[] = str.toCharArray();
        char ch2[] = str1.toCharArray();

        if(ch2[0]=='R') {
            String d = "";
            String m = "";
            String str2 = "";
            long n1 = 0;
            long n2 = 0;
            int count = 0;
            for (int i = 1; i < ch1.length; i++) {
                if (ch2[i] != 'C') {
                    d = d + ch2[i];
                    count++;
                } else {
                    break;
                }
            }
            long column = Integer.parseInt(d);
            for (int j = count + 2; j < ch2.length; j++) {
                m = m + ch2[j];
            }
            long row = Integer.parseInt(m);
            if (row > 26) {
                n1 = (row / 26);
                n2 = row - (n1 * 26);
                if(n1>26){
                System.out.print(ch1[(int) (n1-26-1)] + "" + ch1[(int) (n2 - 1)]);}else{
                    System.out.print(ch1[(int) (n1-1)] + "" + ch1[(int) (n2 - 1)]);
                }
            } else {
                System.out.print(ch1[(int) (row - 1)]);
            }

            str2 = (n1) + "";
            System.out.println(column);
        }
        else {
           int count=0;
           int m1=0;
           for(int k=0;k<ch2.length;k++){
                   if((int)(ch2[k])>=65 && (int)(ch2[k])<=90) {
                       count++;
                   }
           }
            int number=0;
               for(int j=0;j<count;j++){
                   for(int i=0;i<ch1.length;i++){
                       if(ch2[j]==ch1[i]){
                           number = number*26+i+1;
                       }
                   }
               }
               String num1="";
               for(int i =count;i<ch2.length;i++){
                   num1=num1+ch2[i];
               }
          System.out.println("R"+num1+"C"+(number));
        }
    }
}


// R875C898
