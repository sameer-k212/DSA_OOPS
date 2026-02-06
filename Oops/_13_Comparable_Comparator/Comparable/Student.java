package Oops._12_ComparableComparator.Comparable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    int marks;
    int age;
    String name;
    public Student(int marks,int age,String name){
        this.name = name;
        this.marks = marks;
        this.age = age;
    }
    public int getMarks(){
        return marks;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return "marks:"+marks+" "+ "age:"+age+" "+"name:"+name;
    }
    public static void main(String args[]){
        Student st1 = new Student(96,18,"Sameer Kushwaha");
        Student st2 = new Student(85,20,"Sameer Kushwaha");
        Student st3 = new Student(90,17,"Nitin Kushwaha");

        List<Student> student_list = new ArrayList<>();
        student_list.add(st1);
        student_list.add(st2);
        student_list.add(st3);

        System.out.println(student_list); // we will get over here values not address...

//        Collections.sort(student_list);  you will get here compile time error..
//        because the object stored in list is not a simple object(Data of Multiple Types).
//        to solve this issue we need concept of comparable and comparator Interface.

        // using comparable (first you need to implement Comparable to your class)
    }
    public int compareTo(Student a){
        if(this.age > a.age){
            return 1;
        }else {
            return -1;
        }
    }
}