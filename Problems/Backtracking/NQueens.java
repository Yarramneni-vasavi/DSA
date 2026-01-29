import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class NQueens {

    private boolean isSafe(int row, int col, char[][] board, int n) {
        // prev rows column
        for (int i=0; i<row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // left diagonal
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }       
        // right diagonal
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        } 

        return true;
    }

    private void nQueensHelper(int n, int row, char[][] board, List<List<String>> result) {
        if (row == n) {
            //reached end
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(board[i][j]);
                }
                solution.add(sb.toString());
            }
            // adding all solutions to result
            result.add(solution);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(row, i, board, n)) {
                board[row][i] = 'Q';
                nQueensHelper(n, row + 1, board, result);
                board[row][i] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }
        nQueensHelper(n, 0, board, result);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> r = new NQueens().solveNQueens(n);

        for (List<String> list : r) {
            for (String s : list) {    
                System.out.print(s+"|");
            }
            System.out.println();
        }
    }
}