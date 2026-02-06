package Oops._4_Encapsulation;

class Student
{
    private int age;
    private String name;

    public void setAge(int age)
    {
        this.age=age;
    }
    public int getAge()
    {
        return age;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return name;
    }
}

public class Encapsulation {
    public static void main(String args[])
    {
        Student obj= new Student();
        obj.setAge(25);
        obj.setName("sameer");

        int std_age=obj.getAge();
        String std_name=obj.getName();
        System.out.println("Age:"+ std_age);
        System.out.println("Name:"+std_name);

    }
}
