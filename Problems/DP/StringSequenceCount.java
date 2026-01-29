/**
 * Problem: Count the number of distinct subsequences of pattern s2 (e.g., "abc") in string s1.
    For your example:

    s1 = "aabbcc"
    s2 = "abc"
    Answer = 8 (because 2 'a's × 2 'b's × 2 'c's = 8 ways)
 */

import java.util.Arrays;

class StringSequenceCount {
    public int countSubsequences(String text1, String text2) {
        int row = text2.length();
        int col = text1.length();
        int[][] dp = new int[row+1][col+1];

        for (int i=0; i<=row; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i=0; i<=row; i++) {
            dp[i][0] = 1; // first column
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i-1][j];
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(new StringSequenceCount().countSubsequences("aabbcc", "abc"));
    }
}