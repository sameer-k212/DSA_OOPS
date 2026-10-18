
import java.util.ArrayList;
import java.util.List;

public class CoinToss {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        coinToss(3, result, "");
        System.out.println("All possible outcomes for 3 coin tosses: " + result);
        System.out.println("Total outcomes: " + result.size());
    }

    public static void coinToss(int n, List<String> result, String current) {
        if (n == 0) {
            result.add(current);
            return;
        }

        coinToss(n - 1, result, current + "H");
        coinToss(n - 1, result, current + "T");
    }
}