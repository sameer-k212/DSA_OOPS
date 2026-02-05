package DSA.Graph._02_BFS_DFS_Problems._07_NearestCell;

import java.util.*;

public class DistanceOfNearestCellHaving0 {
    class Pair {
        int first;
        int second;
        int depth;

        Pair(int first, int second, int depth) {
            this.first = first;
            this.second = second;
            this.depth = depth;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int n = mat[0].length;
        int m = mat.length;
        int[][] distance = new int[m][n];
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                }
            }
        }


        while (!q.isEmpty()) {
            Pair node = q.remove();
            int first = node.first;
            int second = node.second;
            int depth = node.depth;

            distance[first][second] = depth;

            // Right
            if (second < n - 1 && mat[first][second + 1] == 1 && visited[first][second + 1] == 0) {
                q.add(new Pair(first, second + 1, depth + 1));
                visited[first][second + 1] = 1;
            }

            // Left
            if (second > 0 && mat[first][second - 1] == 1 && visited[first][second - 1] == 0) {
                q.add(new Pair(first, second - 1, depth + 1));
                visited[first][second - 1] = 1;
            }

            // Down
            if (first < m - 1 && mat[first + 1][second] == 1 && visited[first + 1][second] == 0) {
                q.add(new Pair(first + 1, second, depth + 1));
                visited[first + 1][second] = 1;
            }

            // Up
            if (first > 0 && mat[first - 1][second] == 1 && visited[first - 1][second] == 0) {
                q.add(new Pair(first - 1, second, depth + 1));
                visited[first - 1][second] = 1;
            }
        }
        return distance;
    }
}