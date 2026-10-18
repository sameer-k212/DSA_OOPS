
import java.util.ArrayList;
import java.util.List;

public class KidWithCandy {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies)
    {
        ArrayList<Boolean> bool = new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i]>=max)
            {
                max=candies[i];
            }
        }
        System.out.println(max);
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i]+extraCandies>=max)
            {
                bool.add(true);
            }
            else {
                bool.add(false);
            }
        }
        for(int i=0;i<candies.length;i++)
        {
            System.out.print(bool+",");
        }
        return bool;
    }
    public static void main(String args[])
    {
        int arr[]={12,1,12};
        int extra_cand=10;
        ArrayList<Boolean> bool = new ArrayList<>();

    }
}
