
public class StringOperation {
    public static void main(String[] args) {
        String str = "Hello World";

        // 1. length(): Returns the length of the string
        System.out.println("1. Length: " + str.length());

        // 2. charAt(): Returns the character at a specified index
        System.out.println("2. Character at index 1: " + str.charAt(1));

        // 3. substring(): Extracts part of the string
        System.out.println("3. Substring from index 6: " + str.substring(6));
        System.out.println("3. Substring from index 0 to 5: " + str.substring(0, 5));

        // 4. equals(): Compares two strings for equality
        String str2 = "Hello World";
        System.out.println("4. Strings are equal: " + str.equals(str2));

        // 5. equalsIgnoreCase(): Compares two strings ignoring case differences
        String str3 = "hello world";
        System.out.println("5. Strings are equal ignoring case: " + str.equalsIgnoreCase(str3));

        // 6. compareTo(): Compares two strings lexicographically
        System.out.println("6. Compare 'Hello' to 'World': " + "Hello".compareTo("World"));

        // 7. contains(): Checks if a string contains a specific sequence
        System.out.println("7. Contains 'World': " + str.contains("World"));

        // 8. startsWith() and endsWith(): Checks if a string starts or ends with a specific substring
        System.out.println("8. Starts with 'Hello': " + str.startsWith("Hello"));
        System.out.println("8. Ends with 'World': " + str.endsWith("World"));

        // 9. toUpperCase() and toLowerCase(): Converts string to uppercase/lowercase
        System.out.println("9. Uppercase: " + str.toUpperCase());
        System.out.println("9. Lowercase: " + str.toLowerCase());

        // 10. indexOf(): Finds the index of the first occurrence of a substring
        System.out.println("10. Index of 'World': " + str.indexOf("World"));

        // 11. lastIndexOf(): Finds the index of the last occurrence of a substring
        System.out.println("11. Last index of 'l': " + str.lastIndexOf('l'));

        // 12. replace(): Replaces all occurrences of a character or substring
        System.out.println("12. Replace 'World' with 'Java': " + str.replace("World", "Java"));

        // 13. trim(): Removes leading and trailing spaces
        String str4 = "   Hello   ";
        System.out.println("13. Trimmed string: '" + str4.trim() + "'");

        // 14. split(): Splits a string into an array based on a delimiter
        String[] words = str.split(" ");
        System.out.println("14. Split into words:");
        for (String word : words) {
            System.out.println(word);
        }

        // 15. join(): Joins array elements into a single string with a delimiter
        String joined = String.join("-", words);
        System.out.println("15. Joined string with '-': " + joined);

        // 16. isEmpty(): Checks if the string is empty
        String emptyStr = "";
        System.out.println("16. Is the string empty: " + emptyStr.isEmpty());

        // 17. format(): Formats a string using placeholders
        String formatted = String.format("17. %s scored %d points", "John", 90);
        System.out.println(formatted);

        // 18. matches(): Checks if the string matches a regular expression
        String regex = "\\d+";  // Matches any number
        String str5 = "12345";
        System.out.println("18. Matches regex (digits only): " + str5.matches(regex));

        // 19. concat(): Concatenates two strings
        System.out.println("19. Concatenated string: " + str.concat(" Java"));

        // 20. valueOf(): Converts other data types to string
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("20. Converted number to string: " + numStr);
    }
}
