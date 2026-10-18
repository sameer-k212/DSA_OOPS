
/**
 * it is not mindetary that if we have created a class name with file name
 * then we need to put main method inside only it might be possible that
 * you can put your main method to some other class or interface.
 *
 * i am saying interface because after java 8 we have two powerful feature that
 * we can give body to the method if and only method is using method modifier default
 * and static.
 *
 * you can call static method using Interface name
 */
public class Hello {

}

interface Animal {
    int a = 0;
    void eat();
}

interface Bird extends Animal {
    void fly();

    public default void main(String[] args, int arg) {
        System.out.println("Hyy");
    }

    public static void main(String[] args) {
        System.out.println("Hello Sir");
    }
}