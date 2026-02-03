package DSA.Array._07_Hashing._02_Easy_Problems._02_ValidAnagram;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] s1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            s1[idx]++;
        }
        
        int[] s2 = new int[26];
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int idx = ch - 'a';
            s2[idx]++;
        }
        
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        System.out.println(obj.isAnagram("anagram", "nagaram")); // true
        System.out.println(obj.isAnagram("rat", "car")); // false
    }
}
