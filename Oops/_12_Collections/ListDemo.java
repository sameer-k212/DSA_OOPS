package Oops._11_Collections;

import java.util.ArrayList;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int k = 3;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list);
        while(i <= k){
            int first = list.remove(k);
            int end = list.remove(i);
            list.add(i,first);
            list.add(k--,end);
        }
        System.out.println(list);

    }
}
