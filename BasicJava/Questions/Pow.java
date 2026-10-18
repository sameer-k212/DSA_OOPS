
public class Pow {
    public static void main(String[] args) {
        double x=2.0;
        int n=10;
        double result=1;
        while(n>0){
            result=x*result;
            n--;
        }
        System.out.println(result);
    }
}
