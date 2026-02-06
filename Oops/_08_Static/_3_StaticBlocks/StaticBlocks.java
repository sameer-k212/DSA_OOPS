package Oops._6_Static._3_StaticBlocks;
class DatabaseConfig {
    static String url;
    static String username;
    // Static block
    static {   // static blocks execute at time of class loading.
        url = "jdbc:mysql://localhost:3306/mydb";
        username = "admin";
        System.out.println("Static block executed");
    }
}

public class StaticBlocks {
    public static void main(String[] args) {
        System.out.println(DatabaseConfig.url); //  jdbc:mysql://localhost:3306/mydb
    }
}
