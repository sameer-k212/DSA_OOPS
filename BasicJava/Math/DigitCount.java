
public class DigitCount {
    int count=0;
    void digitCount(int num){

        while(num!=0){
            count++;
            num=num/10;
        }
        System.out.println(count);
    }
    void digit(int num)
    {
        int num1=num;
        int last_digit=num%10;
        System.out.println("Last Digit:"+last_digit);
        while(count>1)
        {
            num=num/10;
            count--;
        }
        int first_digit=num;
        System.out.println("First Digit:"+first_digit);
//        Swap first and last digits of a number
        String s=Integer.toString(num1);
        char[] ch=s.toCharArray();
        char temp=ch[0];
        ch[0]=ch[ch.length-1];
        ch[ch.length-1]=temp;
        String str="";
        for(int i=0;i<ch.length;i++){
            str=str+ch[i];
        }
        System.out.println("Swap first and last digits of a number:"+str);
    }
    void freqencyOfNumber(int num)
    {
        int count=0;
        String s=Integer.toString(num);
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            for(int j=i+1;j<ch.length;j++){
                if(ch[i]==ch[j])
                {
                    count++;
                }
            }
            System.out.println(ch[i]+":"+i+1+"times");
            count=0;
        }
    }

    public static void main(String[] args){
        int a=9876;
        DigitCount obj=new DigitCount();
        obj.digitCount(a);
        obj.digit(a);
    }

}
