package Oops.IO._9_Summary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 * Demonstrates reading a text file using BufferedReader.
 *
 * File Operations Overview:
 *
 * File Reading Methods:
 * - FileReader: Reads characters from a file
 * - BufferedReader.readLine(): Reads a line of text
 *
 * File Writing Methods :
 * - FileWriter: Writes characters to a file
 * - BufferedWriter: Buffers characters for efficient writing
 * - PrintWriter: Easy text writing (including println)
 *
 * File Moving / Copying:
 * - Files.move(Path, Path, CopyOption...)
 * - Files.copy(Path, Path, CopyOption...)
 *
 * File Deletion:
 * - File.delete(): Deletes a file or directory
 * - Files.delete(Path): Deletes a file or throws exception
 *
 * File Creation:
 * - File.createNewFile(): Creates a new empty file
 * - Files.createFile(Path): Creates a new file
 *
 * File Info & Checks:
 * - file.exists(): Check if file exists
 * - file.isDirectory(): Check if it's a directory
 * - file.length(): File size in bytes
 * - file.getName(), getPath(), getAbsolutePath(): File metadata
 */

public class BufferedTextReader {
    public static void main(String[] args) {
// Define the file to read
        File file = new File("src/fileReading/byte-input.txt");

// Debugging tip: Print absolute path to confirm location
        System.out.println("Looking for file at: " + file.getAbsolutePath());

// Reading the file using BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

// Read each line until end-of-file (EOF)
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(" File not found or could not be read.");
            e.printStackTrace();
        }

// Example of delete method
// boolean deleted = file.delete(); // returns true if file was deleted

// Example of check if file exists
// boolean exists = file.exists();

// Example of writing to a file (not shown in this class)
// FileWriter fw = new FileWriter("output.txt");

// Example of moving a file (
// Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }
}

