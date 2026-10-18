
public class Power {
    public static void main(String[] args) {
        System.out.println("2^10 = " + power(2, 10));
        System.out.println("3^4 = " + power(3, 4));
        System.out.println("5^0 = " + power(5, 0));
        
        System.out.println("Optimized 2^10 = " + powerOptimized(2, 10));
    }

    public static long power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }

    public static long powerOptimized(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        
        long result = powerOptimized(base, exponent / 2);
        result = result * result;
        
        if (exponent % 2 == 1) {
            result = result * base;
        }
        
        return result;
    }
}