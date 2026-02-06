package Oops._2_Inheritance;

class parent{
    void work(){
        System.out.println("New Work");
    }
}
class child extends parent{
    void work(){
        System.out.println("My Work");
    }
}


class Inheritance {
    public static void main(String args[]){
        parent obj = new parent();
        obj.work();
     //   obj.mywork(); during inheritance parent child property
        //   does not transfer into parent.

        child obj1 = new child();
        obj1.work();
        obj1.work();
     // during inheritance parent property inherit into child.

        parent obj2 = new child(); // A parent type reference can hold
        obj2.work();                          // child type object.
        String str = "";
        System.out.println(str.length());


    //    obj2.mywork(); A parent type reference variable which hold child type
    //           object can not call child method.


     //   child obj3 = new parent(); A child type reference  variable
        // can not hold parent type object;








    }
}
