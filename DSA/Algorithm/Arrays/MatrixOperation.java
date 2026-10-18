
public class MatrixOperation {
    public static void main(String[] args) {
        // printing all permutation of matrix.
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        int rows = matrix.length;
        int cols = matrix[0].length;

        // iterative
        // iterative(matrix,rows,cols);

        // recursive
        recursive(matrix,0,0);
    }
    public static void iterative(int [][]matrix,int rows, int cols) {
        // Step 2: Extract and Print 3x3 Submatrices
        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                // Print the 3x3 submatrix
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        System.out.print(matrix[k][l] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
    public static void recursive(int[][] matrix, int row, int col) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        // If we can't form a 3x3 matrix starting from this row, stop
        if (row > totalRows - 3) {
            return;
        }

        // If we can't form a 3x3 matrix starting from this column, move to the next row
        if (col > totalCols - 3) {
            recursive(matrix, row + 1, 0);
            return;
        }

        // Print the current 3x3 submatrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[row + i][col + j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Recur to the next column in the current row
        recursive(matrix, row, col + 1);
    }
}
