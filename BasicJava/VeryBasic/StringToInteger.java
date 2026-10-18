
public class StringToInteger {
    public static void main(String[] args) {
        multiply("6913259244","71103343");
//        System.out.println(str);
    }
    public static void multiply(String num1, String num2) {
        int value1 = 0;
        int value2 = 0;
        for(int i =0; i<num1.length(); i++){
            String str = "" + num1.charAt(num1.length()-1-i);
            int num = Integer.parseInt(str);
//            value1 = value1*10 +
            System.out.println(num);
        }
    }
}
