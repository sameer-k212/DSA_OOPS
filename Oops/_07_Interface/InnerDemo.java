package Oops._8_Interface;

class P
{
    public void show()
    {
        System.out.println("in A show");
    }
    static class B
    {
        public void display()
        {
            System.out.println("in display");
        }
    }
}


public class InnerDemo {
    public static void main(String[] args) {
        P obj = new P();
        obj.show();

        P.B obj1 = new P.B();
        obj1.display();
    }
}