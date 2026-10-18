
// write a program to remove all special charecter from given string.
class RemoveSpecialChar
{
    void main(String s)
    {
        String m=s.repeat(2); //  use to repeat the string for given times.
        s=s.replaceAll("[^a-z A-Z]","");
        System.out.println(s);
        System.out.println(m);
    }
}
// RemoveWhiteSpace
class RemoveWhiteSpace
{
    void main1(String s)
    {
        //        s=s.replace("\\s","");
        s=s.replace(" ","");
        System.out.println(s);
    }
}

// AscendingOrder
class AscendingOrder
{
    void main2(String s)
    {
        String str="";
        char[] ch=s.toCharArray();
        char temp;  // agar variable ka bas temparary use karna hain print nahi
                   // karna hain toh initialize karne ki jaroorat nahi hain.
        for(int i=0;i<s.length();i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (ch[i]>=ch[j])
                {
                    temp=ch[i];
                    ch[i]=ch[j];
                    ch[j]=temp;
                }
            }
        }
        for(int i=0;i<ch.length;i++)
        {
            System.out.print(ch[i]);
        }
    }
}

// RemoveDuplicate

class RemoveDuplicate
{
    void main3(String s)
    {
        char []ch=s.toCharArray();
        char count=0;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<ch.length;i++)
        {
            for(int j=i+1;j<ch.length;j++)
            {
                if(ch[i]==ch[j])
                {
                    ch[i]='0';
                    count++;
                }

            }
        }
        System.out.println();
        int n=0;
        char []ch1=new char[ch.length-count];
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]!='0')
            {
                ch1[n++]=ch[i];
            }
        }
        for(int i=0;i<ch1.length;i++)
        {
            System.out.print(ch1[i]+" ");
        }
    }

}
// Alone Number
class AloneNumber
{
    int arr1[]={12,2,3,4};
    void aloneNumber(int[] arr) {
        int unique=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[i + 1]) {

            }
        }
    }

}


public class Basic {


    public static void main(String args[]) {
        String str = "$aa>90 b 2c:''c";
        String str1 = "reemas";
        int[] arr={2,3,10,12};
        int arr1[];

//        RemoveSpecialChar obj0=new RemoveSpecialChar();
//        obj0.main(str);

//        RemoveWhiteSpace obj1=new RemoveWhiteSpace();
//        obj1.main1(str);
//
//        AscendingOrder obj2 = new AscendingOrder();
//        obj2.main2(str1);
//
//        RemoveDuplicate obj3=new RemoveDuplicate();
//        obj3.main3(str1);
//

//        AloneNumber obj4=new AloneNumber();
//        obj4.aloneNumber(arr);

    }
}

