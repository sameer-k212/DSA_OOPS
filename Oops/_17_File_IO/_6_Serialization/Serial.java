package Oops.IO._6_Serialization;

import java.io.*;

class Cricketer implements Serializable {
    private String name;
    private int age;
    private int run;
    public Cricketer(String name, int age, int runs){
        this.name = name;
        this.age = age;
        this.run = run;
    }
}
public class Serial {
    public static void main(String[] args) throws Exception {
        Cricketer c = new Cricketer("sachin", 44, 3000);

        FileOutputStream fos = new FileOutputStream("PW/pw.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos); // for efficiency
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(c);
        oos.flush();
        oos.close();



    }
}
