

public class ReversingWords {
    public static void main(String[] args) {
        String ar="Hello.My.Name.Is.Sameer";
        String arg[]=ar.split("\\.");
        String sen="";
        for(int i=arg.length-1;i>=0;i--)
        {
            if(i>=1) {
                sen = sen + arg[i] + ".";
            }
            else{
                sen=sen+arg[i];
            }
        }
        System.out.println(sen);
    }
}
