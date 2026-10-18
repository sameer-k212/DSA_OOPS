
public class StringManipulationExamples {
    public static void main(String[] args) {
        // StringBuilder Examples:
        StringBuilder sb = new StringBuilder("Programming");

        // 1. appendCodePoint(): Appends the string representation of the code point argument
        sb.appendCodePoint(33);  // Appends '!' (ASCII code of 33)
        System.out.println("After appendCodePoint: " + sb);  // Output: Programming!

        // 2. deleteCharAt(): Deletes the character at the specified index
        sb.deleteCharAt(11);  // Removes '!' from the end
        System.out.println("After deleteCharAt: " + sb);  // Output: Programming

        // 3. indexOf(): Finds the index of the first occurrence of a string
        int index = sb.indexOf("gram");
        System.out.println("Index of 'gram': " + index);  // Output: 3

        // 4. lastIndexOf(): Finds the index of the last occurrence of a string
        sb.append(" Programming");
        int lastIndex = sb.lastIndexOf("Programming");
        System.out.println("Last index of 'Programming': " + lastIndex);  // Output: 12

        // 5. subSequence(): Returns a CharSequence between specified indices
        CharSequence sequence = sb.subSequence(0, 5);
        System.out.println("Subsequence from index 0 to 5: " + sequence);  // Output: Progr

        // 6. codePointAt(): Returns the Unicode code point at the specified index
        int codePoint = sb.codePointAt(0);
        System.out.println("Code point at index 0: " + codePoint);  // Output: 80 (ASCII of 'P')

        // 7. codePointBefore(): Returns the code point before the specified index
        int codePointBefore = sb.codePointBefore(1);
        System.out.println("Code point before index 1: " + codePointBefore);  // Output: 80 (ASCII of 'P')

        // 8. codePointCount(): Counts the Unicode code points in a range
        int codePointCount = sb.codePointCount(0, sb.length());
        System.out.println("Code point count: " + codePointCount);  // Output: 24 (Length of the string)

        // 9. offsetByCodePoints(): Returns the index within the string by skipping code points
        int offsetIndex = sb.offsetByCodePoints(0, 2);
        System.out.println("Offset by 2 code points: " + offsetIndex);  // Output: 2

        // StringBuffer Examples:
        StringBuffer sbuf = new StringBuffer("Thread-Safe");

        // 1. capacity(): Shows the current capacity of the StringBuffer
        System.out.println("Capacity of StringBuffer: " + sbuf.capacity());  // Output: 27 (Initial capacity + string length)

        // 2. ensureCapacity(): Ensures the capacity is at least the given minimum
        sbuf.ensureCapacity(50);
        System.out.println("Capacity after ensuring 50: " + sbuf.capacity());  // Output: 54

        // 3. setLength(): Sets the length of the StringBuffer (can trim or expand)
        sbuf.setLength(5);
        System.out.println("After setLength to 5: " + sbuf);  // Output: Threa

        // 4. reverse(): Reverses the contents of the StringBuffer
        sbuf.reverse();
        System.out.println("After reverse: " + sbuf);  // Output: aerhT

        // 5. delete(): Removes a substring between start and end indices
        sbuf.delete(0, 2);  // Removes first 2 characters
        System.out.println("After delete from 0 to 2: " + sbuf);  // Output: rhT

        // 6. insert(): Inserts a string at a specific index
        sbuf.insert(1, "READ");
        System.out.println("After insert at index 1: " + sbuf);  // Output: rREADhT

        // 7. append(): Appends a boolean value
        sbuf.append(true);
        System.out.println("After append true: " + sbuf);  // Output: rREADhTtrue

        // 8. setCharAt(): Sets a character at the specified index
        sbuf.setCharAt(0, 'F');
        System.out.println("After setCharAt index 0: " + sbuf);  // Output: FREADhTtrue

        // 9. replace(): Replaces a substring with another string
        sbuf.replace(0, 4, "READ");
        System.out.println("After replace: " + sbuf);  // Output: READhTtrue

        // 10. substring(): Extracts a substring from the buffer
        String extracted = sbuf.substring(0, 4);
        System.out.println("Substring from 0 to 4: " + extracted);  // Output: READ
    }
}







