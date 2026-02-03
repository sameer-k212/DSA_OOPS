package DSA_OOPS.DSA.Queue._5_Queue_Problems._02_FirstNonRepeatingChar;

import java.util.*;

public class FirstNonRepeatingChar {
    public static String firstNonRepeating(String stream) {
        Queue<Character> queue = new LinkedList<>();
        int[] freq = new int[26];
        StringBuilder result = new StringBuilder();
        
        for (char ch : stream.toCharArray()) {
            freq[ch - 'a']++;
            queue.offer(ch);
            
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }
            
            result.append(queue.isEmpty() ? '#' : queue.peek());
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        String stream = "aabc";
        System.out.println("First non-repeating: " + firstNonRepeating(stream));
    }
}
