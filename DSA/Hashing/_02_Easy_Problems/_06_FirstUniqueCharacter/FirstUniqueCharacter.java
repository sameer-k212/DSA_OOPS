package DSA.Hashing._02_Easy_Problems._06_FirstUniqueCharacter;

import java.util.*;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter obj = new FirstUniqueCharacter();
        System.out.println(obj.firstUniqChar("leetcode")); // 0 (l)
        System.out.println(obj.firstUniqChar("loveleetcode")); // 2 (v)
        System.out.println(obj.firstUniqChar("aabb")); // -1
    }
}
