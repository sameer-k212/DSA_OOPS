package Oops.APIS._1_Date_Time;

public class Demo1 {
    public static void main(String[] args) {
        java.util.ArrayList al = new java.util.ArrayList<>();

        java.util.Date dt = new java.util.Date();
        System.out.println(dt);

        long timeInMs = dt.getTime();

        java.sql.Date dt1 = new java.sql.Date(timeInMs);
        System.out.println(dt1);




    }
}
// write in command prompt: javap java.util.Date