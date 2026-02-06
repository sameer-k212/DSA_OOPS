package Oops._12_ComparableComparator.Comparator;
import java.util.*;
//🔹 Comparable vs Comparator (1-line idea)
//
//Comparator → comparison logic is outside the class
//
//Comparable → comparison logic is inside the class itself

class Alpha implements Comparator<Student> {
    // there is method to return int type data..
    public int compare(Student a, Student b){
        // based on age sorting
        if(a.age > b.age){
            return 1;
        }else{
            return -1;
        }
    }
}
public class Student {
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

        // using comparator (using class implementation)..
        Alpha alpha = new Alpha();
        Collections.<Student>sort(student_list, alpha);
        System.out.println("After sorting...");
        System.out.println(student_list);


        // comparator Interface using Lambda expression
        Comparator<Student> comparator = (Student a, Student b)->{
            // based on age sorting
            if(a.marks > b.marks){
                return 1;
            }else{
                return -1;
            }
        };
        Collections.<Student>sort(student_list, comparator);
        System.out.println(student_list);

//        or..
        Collections.<Student>sort(student_list, (Student a, Student b)->{
            // based on age sorting
            if(a.marks < b.marks){
                return 1;
            }else{
                return -1;
            }
        });
        System.out.println(student_list);




    }

}
