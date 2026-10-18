
//in Java, the == operator compares the
//        references of two objects, not their contents. Since str1[3] and str1[4]
//        are different objects, even though they contain the same character ‘e’, the
//        comparison with == returns false.
//
//        To compare the contents of two strings in Java, you should use the .equals() method
//        instead of ==. Here’s an updated version of your code that uses .equals():

public class RemoveDublicate {
    // approach from string to string array.
    public static String removeDuplicateLetters(String s) {
        String str[]=s.split("");
        for(int i=0;i<str.length;i++){
            for(int j=i+1;j<str.length;j++){
                if((str[i]).equals(str[j])){
                    str[i]=null;
                }
            }
        }
        String str1="";
        for(int i=0;i<str.length;i++){
            if(str[i]!=null){
                str1=str1+str[i];
            }
        }
        return str1;
    }
    // string to char array.
    public static String removeDuplicateLettersch(String s) {
        String s1="";
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            for(int j=i+1;j<ch.length;j++){
                if(ch[i]==ch[j])
                {
                    ch[i]='0';
                }
            }
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i]!='0'){
                s1=s1+ch[i];    // type promotion.
            }
        }
        return s1;

    }
    static String removeDuplicateLetter(String s) {
        char arr[]=s.toCharArray();
        int last[]=new int[26];
        int n=arr.length;
        for(int i=0;i<n;i++)
            last[arr[i]-'a']=i;
        boolean map[]=new boolean[26];
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            int x=ans.length();
            while(x>0 && !map[arr[i]-'a'] && ans.charAt(x-1)>arr[i] && last[ans.charAt(x-1)-'a']>i){
                map[ans.charAt(x-1)-'a']=false;
                ans.deleteCharAt(x-1);
                x=ans.length();
            }
            if(!map[arr[i]-'a']) ans.append(arr[i]);
            map[arr[i]-'a']=true;
        }
        return ans.toString();
    }
        public static void main(String[] args) {
            String str="cbac";

//            String str2=removeDuplicateLetters(str);
//            System.out.println(str2);

            String str3=removeDuplicateLetter(str);
            System.out.println(str3);
        }
    }
