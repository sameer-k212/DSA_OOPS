package DSA.Array_Restructured._01_Basic_Operations._05_FrequencyCount;

import java.util.*;

public class FrequencyCount {
    public static Map<Integer, Integer> countFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return freq;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 2, 3};
        Map<Integer, Integer> freq = countFrequency(arr);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
