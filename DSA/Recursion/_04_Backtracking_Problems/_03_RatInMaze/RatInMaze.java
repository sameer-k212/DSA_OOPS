
import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        
        List<String> paths = new ArrayList<>();
        boolean[][] visited = new boolean[4][4];
        
        findPaths(maze, 0, 0, "", visited, paths);
        System.out.println("All paths from (0,0) to (3,3): " + paths);
    }

    public static void findPaths(int[][] maze, int row, int col, String path, boolean[][] visited, List<String> paths) {
        int n = maze.length;
        
        if (row < 0 || row >= n || col < 0 || col >= n || maze[row][col] == 0 || visited[row][col]) {
            return;
        }
        
        if (row == n - 1 && col == n - 1) {
            paths.add(path);
            return;
        }
        
        visited[row][col] = true;
        
        findPaths(maze, row + 1, col, path + "D", visited, paths);
        findPaths(maze, row, col - 1, path + "L", visited, paths);
        findPaths(maze, row, col + 1, path + "R", visited, paths);
        findPaths(maze, row - 1, col, path + "U", visited, paths);
        
        visited[row][col] = false;
    }
}