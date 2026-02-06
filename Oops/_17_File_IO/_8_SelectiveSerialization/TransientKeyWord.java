package Oops.IO._8_SelectiveSerialization;

import java.io.*;

class Cricketer implements Serializable {
     String name;
     transient int age;
    int run;
    public Cricketer(String name, int age, int run){
        this.name = name;
        this.age = age;
        this.run = run;
    }
    public void display(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(run);
    }
}
public class TransientKeyWord {
    public static void main(String[] args) throws Exception {
//        Cricketer c = new Cricketer("sachin", 44, 3000);
//        c.display();
//
//        FileOutputStream fos = new FileOutputStream("PW/pw.txt");
//        BufferedOutputStream bos = new BufferedOutputStream(fos); // for efficiency
//        ObjectOutputStream oos = new ObjectOutputStream(bos);
//
//        oos.writeObject(c);
//        oos.flush();
//        oos.close();

        FileInputStream fis = new FileInputStream("PW/pw.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Cricketer cr = (Cricketer) ois.readObject();
        cr.display();

        ois.close();


    }
}
