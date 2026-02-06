// Syntax error
package Oops._9_Exception;

class Demo1 {
    public void a() throws Exception {

        b();
    }

    public void b() throws Exception {
        int num1 = 0;
        int num2 = 1;


        int result = num2 / num1;

        System.out.println(result);
    }
}

public class ExceptionFirst {
    public static void main(String[] args) {
        Demo1 obj = new Demo1();

        try {
            obj.a();

        } catch (Exception e) {
            System.out.println("error:" + e);
        }
    }
}