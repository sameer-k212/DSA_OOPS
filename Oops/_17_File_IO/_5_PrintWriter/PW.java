package Oops.IO._5_PrintWriter;

import java.io.*;
public class PW {
    public static void main(String[] args) throws IOException {
        File dir = new File("PW");
        if (!dir.exists()) {
            dir.mkdir();  // Create directory if it doesn't exist
        }

        File file = new File(dir, "pw.txt");

        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.write(97);
        pw.write("\n");
        pw.println("Java");
        pw.print(100);
        pw.println('a');
        pw.println(9.3);
        pw.println(true);

        pw.close();









    }
}
