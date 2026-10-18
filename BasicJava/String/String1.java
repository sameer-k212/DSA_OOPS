
// Anagram

public class String1 {
    public static void main(String args[])
    {
        String str1="Sameer";
        for(int i = 0; i < str1.length(); i++){
            System.out.print(str1.charAt(str1.length()-i-1));
        }
        System.out.println();
//        System.out.println(str1.toLowerCase());
//        System.out.println(toLowerCase(str1));
//        char ch1 = (char)(32 + str1.charAt(0));
//        System.out.println(ch1);
//        String str2="";
//        for(int i=str1.length()-1;i>=0;i--)
//        {
//            str2=str2+str1.charAt(i);
//        }
//        System.out.println(str2);
//        System.out.println(str1);
//
////        Don't use str2==str1;
//
//        if(str2.equals(str1))
//        {
//            System.out.println("pelindram");
//        }
//        else
//        {
//            System.out.println("not pelindram");
//        }
    }


    static int i = 0;
    static String str = "";
    public static String toLowerCase(String s){
        if(i == s.length()){
            return str;
        }
        else{
            str = str + (char)(32 + s.charAt(i));
            i++;
            toLowerCase(s);
        }
        return str;
    }
    static int j = 0;
    public String capitalizeTitle(String title) {
        String str = "";
        final String[] str_arr = title.split(" ");
        title = str_arr[j];
        for(int i = 0; i <  title.length(); i++){
            if( title.charAt(i) >= 'A' && title.charAt(i) <= 'Z')
                str = str + (char)(32 + title.charAt(i));
            else
                str = str + title.charAt(i);
        }
        return str;
    }

}
