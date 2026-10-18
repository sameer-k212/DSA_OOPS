

import javax.lang.model.element.NestingKind;

class Reversing {

    // Reversing 1.
    public static void main(String str)
    {
        String name1="";
        for(int i=str.length()-1;i>=0;i--)
        {
            name1=name1+str.charAt(i);
        }
        System.out.println(name1);

    }

    // Reversing 2.
    public static void main1(String arg)
    {
        String arg1=arg;
        String args[]=arg.split("\\.");
        String str = "";
        int i=args.length-1;
        for(;i>0;i--)
        {
            str = str + args[i]+".";
        }

        str = str + args[i];
        System.out.println(str);

//        String args1[]=arg1.split("");
//        System.out.println();
//        for(int i=arg1.length()-1;i>=0;i--)
//        {
//            System.out.print(args1[i]);
//        }

    }
    public static void main(String args[])
    {
        String str="sameer.kushwaha";

//        Reversing.main(str);
        Reversing.main1(str);
    }
}
