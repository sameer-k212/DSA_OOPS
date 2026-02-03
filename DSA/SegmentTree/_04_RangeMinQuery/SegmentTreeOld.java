package SegmentTree;

public class SegmentTree {
    int segmentTree[];

    public SegmentTree(int n) {
        segmentTree = new int[n * 4]; // Allocate enough space for segment tree
    }

    public void buildSegmentTree(int arr[], int idx, int low, int heigh) {
        if (low == heigh) {
            segmentTree[idx] = arr[low];
            return;
        }
        int mid = (low + heigh) / 2;
        buildSegmentTree(arr, 2 * idx + 1, low, mid);
        buildSegmentTree(arr, 2 * idx + 2, mid + 1, heigh);
        segmentTree[idx] = Math.max(segmentTree[2 * idx + 1], segmentTree[2 * idx + 2]);
    }

    public int maxNumber(int idx, int low, int heigh, int left, int right) {
        if (left <= low && heigh <= right) { // Complete overlap
            return segmentTree[idx];
        }
        if (heigh < left || low > right) { // No overlap
            return Integer.MIN_VALUE;
        }

        int mid = (low + heigh) / 2;
        int l = maxNumber(2 * idx + 1, low, mid, left, right);
        int r = maxNumber(2 * idx + 2, mid + 1, heigh, left, right);
        return Math.max(l, r);
    }

    public static void main(String[] args) {
        int arr[] = {8, 2, 5, 1, 4, 5, 3, 9, 6, 10};
        SegmentTree obj = new SegmentTree(arr.length);
        obj.buildSegmentTree(arr, 0, 0, arr.length - 1);

        // Find the max number from the given range
        int left = 3;
        int right = 8;
        System.out.println(obj.maxNumber(0, 0, arr.length - 1, left, right)); // Output: 9
    }
}
