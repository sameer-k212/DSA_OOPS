
public class MaximumSubString {
    public static void coutmaxstr(String  st){
        String newArr[] = st.split(" ");
//        char str[]  = st.toCharArray();
        int max = 0;
        for (int i =0;i<newArr.length;i++){
            if (newArr[i].length()>max){
                max  = newArr[i].length();
            }
        }
        for (int i = 0;i<newArr.length;i++){
            if (newArr[i].length() == max){
                System.out.println(newArr[i]);
            }
        }
    }
    public static void main(String[] args) {
        String str  = "a a a a";
        coutmaxstr(str);

    }
}
