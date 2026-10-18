
public class counthecharacter {
    public static int count(String  st,int n,char c){
        int count = 0;
        for (int i = 0; i < st.length(); i++)
        {
            if (st.charAt(i) == c){
                count++;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        String str = "sameer";
        int n =10;
        char ch = 'e';
        System.out.println(count(str,n,ch));

    }


}
