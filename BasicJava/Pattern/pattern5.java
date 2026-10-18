//     *
//    * *
//   * * *
//  * * * *
// * * * * *




public class pattern5 {
    public static void main(String args [])
    {
        int n=5;
        int row=1;
        while(row<=n)
        {
            int space=1;
            while(space<=(n-row))
            {
                System.out.print(" ");
                space+=1;
            }
            int star=1;
            while(star<=row)
            {
                System.out.print("* ");
                star+=1;
            }
            System.out.println();
            row+=1;
        }
    }
}
