package Oops.IO._1_CreatingFile;
import java.io.*;
public class LaunchFile2 {
    public static void main(String[] args) throws IOException
    {
//        File dir = new File("SAM1");
//        System.out.println("Absolute Path: " + dir.getAbsolutePath());
//        System.out.println(dir.isDirectory());
//        dir.mkdir();
//        System.out.println("dir is referring to directory SAM1 : " + dir.isDirectory());
//
//        File file = new File(dir, "pwskills.txt");
//        file.createNewFile();
//        System.out.println("file is referrinig to pwskills.txt :"+file.isFile());


        int count = 0;
        File f = new File("SAM1");
        String str[] = f.list();

        for(String name : str){
            System.out.println("File Name: "+name);
            count++;
        }
        System.out.println("No of Files are: " + count);






    }
}
