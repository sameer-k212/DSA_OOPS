
public class StringIsPresentOrNot {
    public static String findOrNot(String s1, String str,int n){
        String newArr[] = str.split(",");
        for (int i = 0;i<n;i++){
            if (newArr[i].equals(s1)){
                return "under";
            }

        }
        return "No Word";
    }
    public static void main(String[] args) {
        String s1 = "thunder";
        String str = "puzzl,thunder,powder,blender,under ";
        int n = 5;
        System.out.println(findOrNot(s1,str,n));

    }


}
