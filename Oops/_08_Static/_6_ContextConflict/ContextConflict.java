package Oops._6_Static._6_ContextConflict;

public class ContextConflict {
    int instanceVar = 10;
    static int staticVar = 20;
    static void staticMethod() {
        // Cannot access instanceVar here, as it belongs to an object
        // System.out.println(instanceVar); // This will give a compilation error
        System.out.println(staticVar); // Static members can be accessed
    }
    void instanceMethod() {
        System.out.println(instanceVar); // Instance members can be accessed                accessed
    }
}
