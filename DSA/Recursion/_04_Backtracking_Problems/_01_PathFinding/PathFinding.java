
import java.util.ArrayList;
import java.util.List;

public class PathFinding {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        
        findAllPaths(result, 3, 3, 0, 0, "");
        System.out.println("All paths from (0,0) to (2,2) in 3x3 grid:");
        System.out.println(result);
        System.out.println("Total paths: " + result.size());
        
        int pathCount = countPaths(3, 3, 0, 0);
        System.out.println("Path count using recursion: " + pathCount);
    }

    public static void findAllPaths(List<String> result, int m, int n, int i, int j, String path) {
        if (i == m - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        if (i < m - 1) {
            findAllPaths(result, m, n, i + 1, j, path + "V");
        }

        if (j < n - 1) {
            findAllPaths(result, m, n, i, j + 1, path + "H");
        }

        if (i < m - 1 && j < n - 1) {
            findAllPaths(result, m, n, i + 1, j + 1, path + "D");
        }
    }

    public static int countPaths(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (i >= m || j >= n) {
            return 0;
        }

        int paths = 0;
        paths += countPaths(m, n, i + 1, j);
        paths += countPaths(m, n, i, j + 1);
        paths += countPaths(m, n, i + 1, j + 1);

        return paths;
    }
}