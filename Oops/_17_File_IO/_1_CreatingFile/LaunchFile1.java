package Oops.IO._1_CreatingFile;
import java.io.*;

public class LaunchFile1 {
    public static void main(String[] args) throws IOException
    {
        // to create file..
//        File file1 = new File("sam.txt");
//        System.out.println(file1.exists()); // false

//        file1.createNewFile();
//        System.out.println(file1.exists()); // true

        // to create Directory...
        File dir1 = new File("SAM");
        System.out.println(dir1.exists());

        dir1.mkdir();
        System.out.println(dir1.isDirectory());








    }
}
