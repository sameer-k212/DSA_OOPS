package Oops.IO._3_BufferWriter;

import java.io.*;


public class BufferWriter {
    public static void main(String[] args) throws IOException
    {
        File dir = new File("PW");
        File file = new File(dir, "pw.txt");

        FileWriter fw = new FileWriter(file); // to avoid overriding you can use FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw); // agar ise close kar diya toh internally fw bhi close ho jayega.

        bw.write("Java");
        bw.newLine();
        bw.write(65);
        bw.newLine();
        char[] ch = {'p', 'w', 's', 'j'};
        bw.write(ch);

        bw.flush(); // ensure 100% data save in file.
        bw.close();

    }
}
