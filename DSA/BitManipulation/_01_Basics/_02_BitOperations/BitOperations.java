package DSA_OOPS.DSA.BitManipulation._01_Basics._02_BitOperations;

public class BitOperations {
    public static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }
    
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }
    
    public static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }
    
    public static int toggleBit(int num, int i) {
        return num ^ (1 << i);
    }
    
    public static int updateBit(int num, int i, int val) {
        num = clearBit(num, i);
        return num | (val << i);
    }
    
    public static void main(String[] args) {
        int num = 10; // 1010
        System.out.println("Get bit 1: " + getBit(num, 1));
        System.out.println("Set bit 0: " + setBit(num, 0));
        System.out.println("Clear bit 1: " + clearBit(num, 1));
        System.out.println("Toggle bit 2: " + toggleBit(num, 2));
    }
}
