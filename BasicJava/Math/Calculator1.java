import java.util.*;
class Clac{
    void operation(int a ,int b,char c){
        switch(c){
            case '+': {
                System.out.println(a+b);
                break;
            }
            case '-': {
                System.out.println(a-b);
                break;
            }
            case '%','/':
                try {
                    System.out.println(a % b + "is remender");
                    System.out.println(a/b+" is divison");

                }
                catch(Exception ex){
                    System.out.println("Zero Division Error.");
                }
                finally {
                    System.out.println("Project completed.");
                }
                break;
            case '*':
                System.out.println(a*b);
                break;
        }
    }
}
public class Calculator1 {
    public static void main(String[] args) {
        Clac obj = new Clac();
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the first number:");
        int a =sc.nextInt();
        System.out.println("Enter the Second number:");
        int b=sc.nextInt();
        System.out.println("Enter the operator which you want to perform:");
        char c =sc.next().charAt(0);
        obj.operation(a,b,c);
    }
}


