import java.util.Arrays;

class SqSubmatrices {
    
    public static void main(String[] args) {
        SqSubmatrices s = new SqSubmatrices();
        int[][] matrix = new int[][]{{1,0,1},
                                     {1,1,0},
                                     {1,1,0}
                                    };
        int res = s.countSquares(matrix);
        System.out.println(res);
    }

    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int count = 0;

        for (int i=0; i<row; i++) {
            
            Arrays.fill(dp[i], 0);
            
            if (matrix[i][0] == 1) {
                dp[i][0] = 1;
                count = count + 1;
            }
        }

        for (int j=1; j<col; j++) {

            if (matrix[0][j] == 1) {
                dp[0][j] = 1;
                count = count + 1;
            }
        }

        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    count = count + dp[i][j];
                }
            }    
        }

        return count;
    }
}