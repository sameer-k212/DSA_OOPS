package DSA_OOPS.DSA.BitManipulation._02_Basic_Problems._02_CountSetBits;

public class CountSetBits {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    
    public static int countSetBitsBuiltIn(int n) {
        return Integer.bitCount(n);
    }
    
    public static void main(String[] args) {
        System.out.println("Set bits in 13: " + countSetBits(13));
        System.out.println("Set bits in 15: " + countSetBits(15));
    }
}
