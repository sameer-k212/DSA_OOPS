package Oops.IO._7_Deserialization;
import java.io.*;

// Important Instruction: 1. Ensure Serialization & Deserialization Use the Same Class
//Both the serializing code (where you write the object to a file) and the deserializing code
// (where you read it back) must use the exact same Cricketer class (same package, same fields).
class Cricketer implements Serializable {
    private String name;
    private int age;
    private int run;
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

public class Dserial {
    public static void main(String[] args) throws Exception
    {
//        Cricketer c = new Cricketer("sachin", 44, 3000);
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
