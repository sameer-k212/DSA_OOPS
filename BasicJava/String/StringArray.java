import java.util.Arrays;
public class StringArray {
    public static void main(String[] args) {
        String s="a good   example";
        String arg[]= s.split(" ");
        int count=0;
        for(int i=0;i<arg.length;i++){
            for(int j=i+1;j<arg.length;j++){
                if(arg[i]==""){
                    arg[i]="0";
                    count++;

                }
            }

        }
        for(int i=0;i<arg.length;i++)
        {
            System.out.print(arg[i]+" ");
        }
        System.out.println();
        System.out.println("count:"+count);
        System.out.println(arg.length);
        int a=0;
        String[] arr=new String[arg.length-count];
        System.out.println(arr.length);
        String str1="";
        for(int i=0;i<arg.length;i++) {
           if(arg[i]!="0")
           {
               if(i<arg.length-2){
                   str1 = str1 + arg[i] + " ";
               }
               else {
                   str1=str1+" "+arg[i];
               }
           }
        }
        System.out.println(str1);
//        String str2="";
//        String arg1[]=str1.split("");
//        for(int i=arg1.length-1;i>=0;i--)
//        {
//            if(i<arg1.length-2){
//                str2 = str2 + arg1[i] + " ";
//            }
//            else {
//                str2=str2+" "+arg1[i];
//            }
//        }
//        System.out.println(str2);
    }
}
