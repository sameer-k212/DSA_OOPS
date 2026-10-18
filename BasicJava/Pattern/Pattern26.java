
public class Pattern26 {
    public static void main(String  args[]) {


        int i = 1;
        int n = 5;
        int x = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                if((i+j)%2==0)
                {
                    System.out.print("1");
                }
                else {
                    System.out.print("0");
                }
                j++;
            }
            i++;
            System.out.println();

        }
    }
}
