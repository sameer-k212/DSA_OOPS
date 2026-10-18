
public class SqrtOfNumber {

            public int mySqrt(int x) {
                int low = 0;
                int high = x;
                int result=-1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    long value = mid * mid;
                    if (value == x) {
                        result = mid;
                        return result;
                    } else if (value > x) {
                        result = mid;
                        high = mid - 1;

                    } else {
                        result = mid;
                        low = mid + 1;
                    }
                }
                return result;
            }
    public static void main(String[] args) {

             int x=4;
        SqrtOfNumber sq=new SqrtOfNumber();
        int sqrt=sq.mySqrt(x);
        System.out.println(sqrt);
    }
}
