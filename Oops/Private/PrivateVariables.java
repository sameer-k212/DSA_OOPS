import java.util.*;

class Student2
{
    private int age; // you can assign value while declearing.
    private String name;


    // initialization of private variable direct in class not possible
//     age=90; it will through error.

    public void setData()
    {
        age=18;
        name="Sameer";
    }

    public void show()
    {
        System.out.println(age+" "+name);
    }
}

class PrivateVariables {
    public static void main(String args[])
    {

        Student2 obj=new Student2();
        // here also we can not change the value of age and name because
        // of private keyword/.
        // obj.name="Nitin";



        obj.setData();
        obj.show();

    }
}



