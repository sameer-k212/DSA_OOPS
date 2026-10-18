
public class DiceRoll {
    public static void main(String[] args) {
        System.out.println("All ways to get sum 4 with 6-faced dice:");
        dice(6, 4, "");
        
        System.out.println("\nAll ways to get sum 6 with 6-faced dice:");
        dice(6, 6, "");
    }

    public static void dice(int faces, int target, String current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }
        
        if (target < 0) {
            return;
        }

        for (int i = 1; i <= faces; i++) {
            dice(faces, target - i, current + i);
        }
    }
}