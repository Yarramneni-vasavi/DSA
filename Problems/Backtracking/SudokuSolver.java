class SudokuSolver {
    int BOARD_LENGTH = 9; // board length = constant
    // only one solution possible - Given in question
    // modification in-place board
    private boolean isSafe(char[][] board, int row, int col, char num) {
        // check if num is already repeated in that row
        for (int i=0; i < BOARD_LENGTH; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // check if num is already repeated in that col
        for (int i=0; i < BOARD_LENGTH; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        // check if num is already repeated in that grid
        int gridRowStart = (row / 3) * 3;
        int gridColStart = (col / 3) * 3;

        for (int i = gridRowStart; i < gridRowStart + 3; i++) {
            for (int j = gridColStart; j < gridColStart + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_LENGTH; j++) {
                if (board[i][j] == '.') {
                    for (int k = 1; k <= BOARD_LENGTH; k++) {
                        char res = (char) ('0' + k);
                        if (isSafe(board, i, j, res)) {
                            board[i][j] = res;
                            
                            if (solveSudokuHelper(board)) {
                                return true;
                            }
                            
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    public static void main(String[] args) {
        char[][] input = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new SudokuSolver().solveSudoku(input);

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}