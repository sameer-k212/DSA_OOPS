
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Original Sudoku:");
        printBoard(board);
        
        if (solveSudoku(board)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists!");
        }
    }

    public static boolean solveSudoku(char[][] board) {
        return solveSudokuHelper(board, 0, 0);
    }

    private static boolean solveSudokuHelper(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solveSudokuHelper(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solveSudokuHelper(board, row, col + 1);
        }

        for (int digit = 1; digit <= 9; digit++) {
            char ch = (char) (digit + '0');
            
            if (isValidPlacement(board, row, col, ch)) {
                board[row][col] = ch;
                
                if (solveSudokuHelper(board, row, col + 1)) {
                    return true;
                }
                
                board[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isValidPlacement(char[][] board, int row, int col, char digit) {
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("------+-------+------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}