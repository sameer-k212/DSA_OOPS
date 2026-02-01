package DSA.zSomeImpProblems;
import java.util.*;
public class Highest_Frequency_Element {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int maxfreq = 0;
        int maxfreqele = 0;
        HashMap<Integer, Integer> hm =  new HashMap<>();
        for(int i = 0; i < n ; i++){
            int val = sc.nextInt();

            int freq = hm.getOrDefault(val,0)+1;

            hm.put(val,freq);

            if(freq > maxfreq){
                maxfreq = freq;
                maxfreqele = val;
            }
        }
        System.out.println(maxfreqele);

    }
}