package DSA.Two_Pointer;
//removing all non-alphanumeric characters, it reads the same forward and backward.
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//        Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.

import java.util.Arrays;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        str = str.replaceAll("[^ a-z A-Z 0-9]", "");
        String s[] = str.split(" ");
        String st = "";
        for(String temp : s){
            st += temp;
        }
        System.out.println(st); // this is non spaced string...

        // Now i can write a logic for anagram testing...
    }
}
