package DSA_OOPS.DSA.BitManipulation._01_Basics._01_BitwiseOperators;

public class BitwiseOperators {
    public static void main(String[] args) {
        int a = 5, b = 3;  // 101, 011
        
        System.out.println("AND: " + (a & b));      // 001 = 1
        System.out.println("OR: " + (a | b));       // 111 = 7
        System.out.println("XOR: " + (a ^ b));      // 110 = 6
        System.out.println("NOT: " + (~a));         // -6
        System.out.println("Left Shift: " + (a << 1));   // 1010 = 10
        System.out.println("Right Shift: " + (a >> 1));  // 010 = 2
        System.out.println("Unsigned Right: " + (a >>> 1)); // 010 = 2
    }
}
