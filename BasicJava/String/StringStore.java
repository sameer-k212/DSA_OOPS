
public class StringStore {
    public static void main(String[] args) {
        String name=new String("Sameer"); //heap
   // and scp and reference variable will indicate object of heap.


        String name1="Sameer";//scp reference vaiable will indicate
                             // object of scp.

        String name2="Sameer"; // scp
        if(name==name1)
        {
            System.out.println(true);
        }
        else
            System.out.println(false);
    }
}
