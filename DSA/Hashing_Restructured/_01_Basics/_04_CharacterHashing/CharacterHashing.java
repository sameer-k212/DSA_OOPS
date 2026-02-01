package DSA.Hashing_Restructured._01_Basics._04_CharacterHashing;

public class CharacterHashing {
    public static void main(String[] args) {
        int[] arr = new int[26]; // For lowercase a-z
        String str = "abcdabcfghyb";
        
        // Count frequency
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            arr[val]++;
        }

        // Query frequencies
        String query = "abcd";
        System.out.println("String: " + str);
        System.out.println("Query: " + query);
        System.out.print("Frequencies: ");
        for (int i = 0; i < query.length(); i++) {
            System.out.print(arr[query.charAt(i) - 'a'] + " ");
        }
    }
}
