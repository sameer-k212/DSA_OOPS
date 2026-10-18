
import java.util.PriorityQueue;
import java.util.*;
//Kth Largest Elements in an array
//1. using minheap
class Problems {
    public int minFindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int num : nums) {
            minheap.add(num);
            // deletion of elements from the minheap n-k times
            if (minheap.size() > k) {
                minheap.remove();
            }
        }

        return minheap.peek();
    }


// 2. using maxheap

    public int maxFindKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            maxheap.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            maxheap.remove();
        }

        return maxheap.peek();
    }

//Kth closest Points to Origin
//1. using minheap

// time complexity: O(k log n)
// worst case k = n, O(n log n)
// space complexity: O(k)


    public class Point implements Comparable<Point> {
        int x;
        int y;
        double distance;
        int i;

        // constructor initialization
        public Point(int x, int y, double distance, int i) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.i = i;
        }

        @Override
        public int compareTo(Point p1) {
            // sort the data on the basis of distance in the ascending order
            return Double.compare(this.distance, p1.distance);
        }
    }


    public int[][] kClosest(int[][] points, int k) {
        // 1. creation of a minheap - O(n)
        PriorityQueue<Point> minheap = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            // euclidean distance formula
            // sqrt(x^2 + y^2)
            double distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            minheap.add(new Point(points[i][0], points[i][1], distance, i));
        }

        //2. Deletion from the minheap until k times - O(k log n)
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            Point point = minheap.remove();
            result[i] = new int[]{points[point.i][0], points[point.i][1]};
        }

        return result;
    }

    public static void main(String[] args) {

    }
}

