package Oops._6_Static._1_StaticVariable;

class Student {
    static int totalStudents = 0; // Static variable shared by all instances
    String name;
    Student(String name) {
        this.name = name;
        totalStudents++; // Increment totalStudents each time a new student is created
    }
}

public class StaticVariable {
    public static void main(String[] args) {
        Student s1 = new Student("John");
        Student s2 = new Student("Jane");
        System.out.println(Student.totalStudents); // Output: 2
    }
}
