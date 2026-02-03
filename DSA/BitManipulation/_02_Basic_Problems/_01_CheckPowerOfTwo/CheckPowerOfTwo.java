package DSA_OOPS.DSA.BitManipulation._02_Basic_Problems._01_CheckPowerOfTwo;

public class CheckPowerOfTwo {
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    
    public static void main(String[] args) {
        System.out.println("16 is power of 2: " + isPowerOfTwo(16));
        System.out.println("18 is power of 2: " + isPowerOfTwo(18));
    }
}
