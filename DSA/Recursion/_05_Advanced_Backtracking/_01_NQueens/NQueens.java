
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        System.out.println("Solutions for 4-Queens problem:");
        List<List<String>> solutions = solveNQueens(4);
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println("Solution " + (i + 1) + ":");
            printBoard(solutions.get(i));
            System.out.println();
        }
        
        System.out.println("Total solutions for 4-Queens: " + solutions.size());
        System.out.println("Total solutions for 8-Queens: " + solveNQueens(8).size());
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        solveNQueensHelper(board, 0, solutions);
        return solutions;
    }

    private static void solveNQueensHelper(char[][] board, int row, List<List<String>> solutions) {
        if (row == board.length) {
            solutions.add(constructSolution(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solveNQueensHelper(board, row + 1, solutions);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    private static void printBoard(List<String> board) {
        for (String row : board) {
            System.out.println(row);
        }
    }
}