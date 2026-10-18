import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class UseFullMethodsInArrays {
    public static void main(String[] args) {
        // 1. Arrays.toString()
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Arrays.toString(): " + Arrays.toString(arr1));

        // 2. Arrays.sort()
        int[] arr2 = {5, 3, 1, 4, 2};
        Arrays.sort(arr2);
        System.out.println("Arrays.sort(): " + Arrays.toString(arr2));

        // 3. Arrays.binarySearch()
        int index = Arrays.binarySearch(arr2, 3);
        System.out.println("Arrays.binarySearch(): Index of 3 is " + index);

        // 4. Arrays.equals()
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1, 2, 3};
        int[] arr5 = {1, 2, 4};
        System.out.println("Arrays.equals(): arr3 and arr4 are equal: " + Arrays.equals(arr3, arr4));
        System.out.println("Arrays.equals(): arr3 and arr5 are equal: " + Arrays.equals(arr3, arr5));

        // 5. Arrays.fill()
        int[] arr6 = new int[5];
        Arrays.fill(arr6, 10);
        System.out.println("Arrays.fill(): " + Arrays.toString(arr6));

        // 6. Arrays.copyOf()
        int[] arr7 = {1, 2, 3};
        int[] arr8 = Arrays.copyOf(arr7, 5);
        System.out.println("Arrays.copyOf(): " + Arrays.toString(arr8));

        // 7. Arrays.copyOfRange()
        int[] arr9 = {1, 2, 3, 4, 5};
        int[] arr10 = Arrays.copyOfRange(arr9, 1, 4);
        System.out.println("Arrays.copyOfRange(): " + Arrays.toString(arr10));

        // 8. Arrays.deepEquals()
        int[][] arr11 = {{1, 2}, {3, 4}};
        int[][] arr12 = {{1, 2}, {3, 4}};
        int[][] arr13 = {{1, 2}, {5, 6}};
        System.out.println("Arrays.deepEquals(): arr11 and arr12 are deeply equal: " + Arrays.deepEquals(arr11, arr12));
        System.out.println("Arrays.deepEquals(): arr11 and arr13 are deeply equal: " + Arrays.deepEquals(arr11, arr13));

        // 9. Arrays.deepToString()
        System.out.println("Arrays.deepToString(): " + Arrays.deepToString(arr11));

        // 10.
        int sum = Arrays.stream(arr1).sum();
        System.out.println("Sum using Arrays.stream(): " + sum);

        // 11.
        int []arr = {5, 3, 1, 4, 2};
        Arrays.parallelSort(arr);
        System.out.println("Arrays.parallelSort(): " + Arrays.toString(arr));

        // 12.
        String[] strarr = {"apple", "banana", "cherry"};
        List<String> list = Arrays.asList(strarr);
        System.out.println("Arrays.asList(): " + list);

        //13.
        arr = new int[5];
        Arrays.setAll(arr, i -> i * i);
        System.out.println("Arrays.setAll(): " + Arrays.toString(arr));

        //14.
        int ans[] = {1, 2, 3, 4, 5};
        String result = Arrays.stream(ans)
                .filter(n -> n % 2 == 0) // filter even numbers
                .mapToObj(String::valueOf) // convert to String
                .collect(Collectors.joining(", "));
        System.out.println("Filtered and joined: " + result);

        //15.
        double[] arrdouble = {1.5, 2.5, 3.5};
        double average = Arrays.stream(arrdouble).average().orElse(0);
        System.out.println("Average using Arrays.stream(): " + average);

        //16.
        int ans1[] = {1, 2, 3, 4, 5};
        Spliterator<Integer> spliterator = Arrays.spliterator(ans1);
        spliterator.forEachRemaining(System.out::println);

        // 17.
        Integer[] integers = {1, 2, 3, 4, 5};
        int sumation = Arrays.stream(integers)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of Integers: " + sumation);


        // 18.
        // 19.
        // 20.
        // 20.

    }
}

