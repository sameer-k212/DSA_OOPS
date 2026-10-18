
public class StringBuilderDemo {
    public static void main(String[] args) {
        // 1. append(): Adds a string to the end
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("After append: " + sb.toString());  // Output: Hello World

        // 2. insert(): Inserts a string at the specified index
        sb.insert(5, ",");
        System.out.println("After insert: " + sb.toString());  // Output: Hello, World

        // 3. replace(): Replaces characters between specified indices
        sb.replace(7, 12, "Everyone");
        System.out.println("After replace: " + sb.toString());  // Output: Hello, Everyone

        // 4. delete(): Removes characters between the specified indices
        sb.delete(5, 7);
        System.out.println("After delete: " + sb.toString());  // Output: HelloEveryone

        // 5. reverse(): Reverses the characters in the StringBuilder
        sb.reverse();
        System.out.println("After reverse: " + sb.toString());  // Output: enoyrevElloH

        // 6. charAt(): Returns the character at a specified index
        char ch = sb.charAt(2);
        System.out.println("Character at index 2: " + ch);  // Output: o

        // 7. setCharAt(): Modifies the character at the specified index
        sb.setCharAt(2, 'X');
        System.out.println("After setCharAt: " + sb.toString());  // Output: enXyrevElloH

        // 8. length(): Returns the length of the string
        int length = sb.length();
        System.out.println("Length of string: " + length);  // Output: 12

        // 9. substring(): Returns a substring between specified indices
        String substring = sb.substring(2, 5);
        System.out.println("Substring from index 2 to 5: " + substring);  // Output: Xyr

        // 10. toString(): Converts StringBuilder to String
        String finalString = sb.toString();
        System.out.println("Final string: " + finalString);  // Output: enXyrevElloH

        // 11. capacity(): Returns the current capacity of the StringBuilder
        int capacity = sb.capacity();
        System.out.println("Capacity: " + capacity);  // Output: 27 (Initial capacity is 16 + current length)

        // 12. ensureCapacity(): Ensures that the capacity is at least the specified minimum
        sb.ensureCapacity(50);
        System.out.println("Capacity after ensureCapacity(50): " + sb.capacity());  // Output: 54

        // 13. trimToSize(): Reduces the capacity to the current size of the string
        sb.trimToSize();
        System.out.println("Capacity after trimToSize: " + sb.capacity());  // Output: 12
    }
}
