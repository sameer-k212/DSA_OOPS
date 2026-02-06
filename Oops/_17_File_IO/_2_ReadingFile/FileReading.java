package Oops.IO._2_ReadingFile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReading {
    public static void main(String[] args) throws IOException
    {
        File dir = new File("PW");
        File file = new File(dir, "pw.txt");

        FileReader fr = new FileReader(file);
//        int i = fr.read();
//        System.out.println((char)i);
//
//        while(i != -1){
//            System.out.print(i+"----->");
//            System.out.println((char)i);
//            i = fr.read();
//        }

        // Another way to read the file without calling read() more and more.
        char[] ch = new char[(int)file.length()];
        fr.read(ch);
        for(char data : ch){
            System.out.print(data);
        }



    }
}
