package DSA.Graph_Restructured._05_Shortest_Path._06_ShortestPathBinaryMatrix;

import java.util.*;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], dist = curr[2];
            
            if (row == n-1 && col == n-1) return dist;
            
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && 
                    grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                    grid[newRow][newCol] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix obj = new ShortestPathBinaryMatrix();
        int[][] grid = {{0,1},{1,0}};
        System.out.println(obj.shortestPathBinaryMatrix(grid)); // 2
    }
}
