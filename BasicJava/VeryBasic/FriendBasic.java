
public class FriendBasic {
    public static void main(String[] args) {
        int i = 1;
        int j = 0;
        switch (i) {
            case 1:
                j = j + 2;
            case 2:
                ++j;
                break;
            case 3:
                j++;
            default:
                j = 5;
                break;
        }
        System.out.println(j);
    }
}
