package DSA.Graph_Restructured._02_BFS_DFS_Problems._04_NumberOfIslands;
import java.util.*;
// Digonal 1 is not consider as is it is not top, bottom or left, right(4 direction) to any one figure is for(8dir).
class Island {
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    };
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    BFS(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void BFS(char grid[][], int visited[][], int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair node = q.remove();
            int first = node.first;
            int second = node.second;

            // Right
            if (second < n - 1 && grid[first][second + 1] == '1' && visited[first][second + 1] == 0) {
                visited[first][second + 1] = 1;
                q.add(new Pair(first, second + 1));

            }

            // Left
            if (second > 0 && grid[first][second - 1] == '1' && visited[first][second - 1] == 0) {
                visited[first][second - 1] = 1;
                q.add(new Pair(first, second - 1));

            }

            // Down
            if (first < m - 1 && grid[first + 1][second] == '1' && visited[first + 1][second] == 0) {
                visited[first + 1][second] = 1;
                q.add(new Pair(first + 1, second));

            }

            // Up
            if (first > 0 && grid[first - 1][second] == '1' && visited[first - 1][second] == 0) {
                visited[first - 1][second] = 1;
                q.add(new Pair(first - 1, second));

            }

        }

    }
}
