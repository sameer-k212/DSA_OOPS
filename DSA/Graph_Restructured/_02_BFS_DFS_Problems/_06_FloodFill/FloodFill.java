package DSA.Graph_Restructured._02_BFS_DFS_Problems._06_FloodFill;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    static class Pair{
        int first,second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    };
    public static void BFS(int [][]image, int[][] visited, int sr, int sc, int color){
        int m = image.length;
        int n = image[0].length;

        visited[sr][sc] = 1;
        int initial = image[sr][sc];

        image[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));

        while(!q.isEmpty()){
            Pair node =  q.remove();
            int first = node.first;
            int second = node.second;

            // Right
            if (second < n - 1 && image[first][second + 1] == initial  && visited[first][second + 1] == 0) {
                q.add(new Pair(first, second + 1));
                image[first][ second + 1] = color;
                visited[first][second + 1] = 1;
            }

            // Left
            if (second > 0 && image[first][second - 1] == initial && visited[first][second - 1] == 0) {
                q.add(new Pair(first, second - 1));
                image[first][ second - 1] = color;
                visited[first][second - 1] = 1;
            }

            // Down
            if (first < m - 1 && image[first + 1][second] == initial && visited[first + 1][second] == 0) {
                q.add(new Pair(first + 1, second));
                image[first + 1][second] = color;
                visited[first + 1][second] = 1;
            }

            // Up
            if (first > 0 && image[first - 1][second] == initial && visited[first - 1][second] == 0) {
                q.add(new Pair(first - 1, second));
                image[first - 1][second] = color;
                visited[first - 1][second] = 1;
            }


        }
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] visited = new int[image.length][image[0].length];
        BFS(image,visited,sr,sc,color);

    }
}
