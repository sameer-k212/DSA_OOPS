
class SumOfOddNatural{
    void main(int a,int b){
        int addition=0;
        while(a<=b){
            if(a%2!=0){
                addition=addition+a;
            }
            a++;
        }
        System.out.println("SumOfOddNatural:"+addition);
    }
}
class SumOfEvenNatural{
    void main(int a,int b){
        int addition=0;
        while(a<=b){
            if(a%2==0){
                addition=addition+a;
            }
            a++;
        }
        System.out.println("SumOfEvenNatural:"+addition);
    }
}
public class NaturalNumber {
    void main(int a,int b){
        int sum=0;
        while(a<=b){
            if(a<=b-1){
                sum=sum+a;
            System.out.print(a+",");}
            else{
                sum=sum+a;
                System.out.print(a+".");
            }
            a++;
        }
        System.out.println();
        System.out.print("Sum:"+sum);
        System.out.println();
    }
    public static void main(String[] args){
        int a=1;
        int b=10;
        NaturalNumber obj=new NaturalNumber();
        obj.main(a,b);
        SumOfOddNatural obj1=new SumOfOddNatural();
        obj1.main(a,b);
        SumOfEvenNatural obj2=new SumOfEvenNatural();
        obj2.main(a,b);
    }
}
