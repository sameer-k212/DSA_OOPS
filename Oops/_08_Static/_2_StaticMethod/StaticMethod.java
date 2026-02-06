package Oops._6_Static._2_StaticMethod;
class MathUtility {
    // Static method
    static int add(int a, int b) {
        return a + b;
    }
}
public class StaticMethod {
    public static void main(String[] args) {
        int sum = MathUtility.add(5, 10); // No need to create an instance of MathUtility
        System.out.println(sum); // Output: 15
    }
}
