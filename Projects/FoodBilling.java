
import java.sql.SQLOutput;
import java.util.Scanner;

public class FoodBilling {
    int bill;
    int veg_cost;
    int non_veg_cost;
    public int main(String s)
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the distance:");
        int distance=scan.nextInt();
        System.out.println("Enter the quantity of order:");
        int quantity_of_order=scan.nextInt();

        if(s.charAt(0)=='v'){
        System.out.println("Enter the cost of veg food:");
        veg_cost=scan.nextInt();
        }
        else{
        System.out.println("Enter the cost of non veg food:");
        non_veg_cost=scan.nextInt();
        }
        int delevery_cost;
        if(distance>6)
        {
            delevery_cost=1+2*(distance-6);
        }
        else if(distance>3&&distance<=6)
        {
            delevery_cost=1;
        }
        else{
            delevery_cost=0;
        }
        if((s.charAt(0)=='v' && distance>0 && quantity_of_order>=1 && veg_cost!=0) ||
                (s.charAt(0)=='n' && distance>0 && quantity_of_order>=1&& non_veg_cost!=0))
        {

            if(s.charAt(0)=='v')
            {
                bill=quantity_of_order*veg_cost+delevery_cost;
            }
            else {
                bill=quantity_of_order*non_veg_cost+delevery_cost;
            }
            return bill;

        }
        else {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println();
        System.out.println("WELCOME TO THE HOTEL SIR,");
        System.out.println("Enter the food type you want to order:");
        String s=sc.next();
        FoodBilling obj=new FoodBilling();
        int bill=obj.main(s);
        System.out.println("Bill will be:");
        System.out.println(bill);
        System.out.println("THANKS FOR ORDERING .");
    }
}
