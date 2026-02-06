package Oops._6_Static._4_StaticClass;


class OuterClass {
    static class StaticNestedClass {
        void display() {
            System.out.println("Inside static nested class");
        }

        public static void main(String[] args) {
            System.out.println("Hyy There");
        }
    }
    public static void main(String args[]){
        System.out.println("Hello");
    }
}

class StaticClass {
    public static void main(String[] args) {
        OuterClass obj1 = new OuterClass();
//        obj1.display(); not possible

        StaticClass obj2 = new StaticClass();
//        obj2.display(); not possible

        OuterClass.StaticNestedClass nested = new
                OuterClass.StaticNestedClass();
        nested.display(); // Output: Inside static nested class
    }
}

