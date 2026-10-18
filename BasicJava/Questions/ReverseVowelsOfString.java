
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String s="leetcode";
        char[] S=s.toCharArray();
        for(int i=0;i<S.length/2;i++){
            if((S[i]=='a'||
                    S[i]=='e'|| S[i]=='i'|| S[i]=='o'||S[i]=='u') &&
                    (S[S.length-1-i]=='a' || S[S.length-1-i]=='a' ||
                    S[S.length-1-i]=='e' ||S[S.length-1-i]=='i'
                    ||S[S.length-1-i]=='o' || S[S.length-1-i]=='u')){
                char temp=S[i];
                S[i]=S[S.length-1-i];
                S[S.length-1-i]=temp;
            }
        }
        String str="";
        for(int i=0;i<S.length;i++)
        {
            str=str+S[i];
        }
        System.out.println(str);
    }
}
