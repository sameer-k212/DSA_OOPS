
public class Function2 {
    int m; // yaha value doge to m ka scope pure class main hoga so
            // that value can not be chagne.
    public static void New(int n) // ise ham static banye
                                //  kyunki m instance agar static hoga toh obj
//       create karna padega.
    {
        Function2 obj1= new Function2();  // here a new object will be create.
        n=7;
        obj1.m=n;
        System.out.println(obj1.m);
    }
    int getValue()
    {
//        System.out.println(n);     we can not print n because scope of n is depend
                    //s on {}.
        return m;
    }
    public static void main(String args[])
    {
        Function2 obj= new Function2(); // here we have create an obj because the
        // scope depends on the positon of {}.
        int n=10;
        obj.New(n);
        System.out.print(obj.getValue());
    }
}
