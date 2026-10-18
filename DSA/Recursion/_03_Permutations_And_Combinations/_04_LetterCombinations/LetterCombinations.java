
import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        letterCombinations("23", result);
        System.out.println("Letter combinations of '23': " + result);
        
        result.clear();
        letterCombinations("234", result);
        System.out.println("Letter combinations of '234': " + result);
    }

    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public static void letterCombinations(String digits, List<String> result) {
        if (digits == null || digits.length() == 0) {
            return;
        }
        letterCombinationsHelper(digits, 0, "", result);
    }

    private static void letterCombinationsHelper(String digits, int index, String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        char digit = digits.charAt(index);
        String letters = KEYPAD[digit - '0'];

        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsHelper(digits, index + 1, current + letters.charAt(i), result);
        }
    }
}