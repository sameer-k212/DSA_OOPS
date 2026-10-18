public class Probability {
    public static void main(String[] args) {
        double d = calculateProbability(50);
        System.out.println(d);
    }
    public static double calculateProbability ( int n) {
        double x = 1;
        for ( int i =0; i<n; i++){
            x *= (365.0 - i)/365.0;
        }
        double pro = Math.round((1 - x) * 100);
        return pro/100;
    }
}
