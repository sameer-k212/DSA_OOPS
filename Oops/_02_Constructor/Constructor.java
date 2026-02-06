package Oops._1_Constructor;


 class Demo1 {
    private int a;
    private String name = "sameer";

    Demo1(int a, String name) {
        this.a = a;
        this.name = name;
    }

    void disp() {
        System.out.println(a);
        System.out.println(name);
    }
    Demo1()
    {
        System.out.println("this code is exicuted part of " +
                "zero paremeterise constructor.");

    }
}
    class Constructor {
        public static void main(String args[]) {
         Demo1 d=new Demo1();
//          now you have to create a constructor because you had already
//          used parameteise constructor. now by defaultly will not create so that
//             Demo d=new Demo(); it is also call of zero perimeterise
//             constructor not default constructor will not create by itself
//             now we will create manually.
//             like: see upper side>
//
//            


            Demo1 d1 = new Demo1(10, "sameer");
            d1.disp();

        }
    }
