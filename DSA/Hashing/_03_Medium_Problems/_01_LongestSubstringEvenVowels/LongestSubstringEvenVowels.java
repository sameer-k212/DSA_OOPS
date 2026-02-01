package DSA.Hashing._03_Medium_Problems._01_LongestSubstringEvenVowels;

import java.util.*;

public class LongestSubstringEvenVowels {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> stateMap = new HashMap<>();
        stateMap.put(0, -1);

        int maxLen = 0;
        int state = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'a') {
                state ^= 1 << 0;
            } else if (c == 'e') {
                state ^= 1 << 1;
            } else if (c == 'i') {
                state ^= 1 << 2;
            } else if (c == 'o') {
                state ^= 1 << 3;
            } else if (c == 'u') {
                state ^= 1 << 4;
            }

            if (stateMap.containsKey(state)) {
                maxLen = Math.max(maxLen, i - stateMap.get(state));
            } else {
                stateMap.put(state, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringEvenVowels obj = new LongestSubstringEvenVowels();
        System.out.println(obj.findTheLongestSubstring("eleetminicoworoep")); // 13
    }
}
