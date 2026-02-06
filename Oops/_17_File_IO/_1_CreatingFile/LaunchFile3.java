package Oops.IO._1_CreatingFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LaunchFile3 {
    public static void main(String[] args)  throws IOException
    {
        File dir = new File("PW"); // path
        dir.mkdir();

        File file = new File(dir, "pw.txt"); // path
//        file.createNewFile();

//        FileWriter fw = new FileWriter(file);
        FileWriter fw = new FileWriter(file, true);
        fw.write("Hello My Name is Sameer.");
        fw.write("\n");
        fw.write(65);
        fw.write("\n");
        fw.write(97);
        fw.write("\n");
        char ch[] = {'j', 'a', 'v', 'a'};
        fw.write(ch);

        fw.close(); // ise write close ho jayega aur data file me aa jayega
        fw.flush(); // ise data file me aa jayega, aur aap further likh sakte ho file and baad me close kar dena


        System.out.println("open pw.text to see the result");

    }
}
