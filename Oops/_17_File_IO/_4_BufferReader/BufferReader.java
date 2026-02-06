package Oops.IO._4_BufferReader;

import java.io.*;

public class BufferReader {
    public static void main(String[] args) {
        File dir = new File("PW");
        File file = new File(dir, "pw.txt");

        BufferedReader br = null;
        try{
            FileReader fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
