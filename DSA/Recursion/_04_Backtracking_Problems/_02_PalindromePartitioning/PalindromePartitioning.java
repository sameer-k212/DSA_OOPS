
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        palindromePartition("aab", new ArrayList<>(), result, 0);
        System.out.println("All palindrome partitions of 'aab': " + result);
        
        result.clear();
        palindromePartition("racecar", new ArrayList<>(), result, 0);
        System.out.println("All palindrome partitions of 'racecar': " + result);
    }

    public static void palindromePartition(String str, List<String> current, List<List<String>> result, int start) {
        if (start == str.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            String substring = str.substring(start, i + 1);
            
            if (isPalindrome(substring)) {
                current.add(substring);
                palindromePartition(str, current, result, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}