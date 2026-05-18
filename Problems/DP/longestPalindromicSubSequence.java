public class longestPalindromicSubSequence {
    public static void main(String[] args) {
        int res = new longestPalindromicSubSequence().longestPalindromeSubseq("cbbd");
        System.out.println(res);
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] maxLengthPalindromePossible = new int[n][n];

        for (int i=0, j=0; j<n; i++, j++) {
            maxLengthPalindromePossible[i][j] = 1;
        }

        boolean isFirstDiagonal = true;
        for (int l=1; l<n; l++) {
            if (l >= 2) {
                isFirstDiagonal = false;
            }
            for (int i=0, j=l; i<n-l && j < n; i++, j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    maxLengthPalindromePossible[i][j] = isFirstDiagonal ? 2 : 2 + maxLengthPalindromePossible[i+1][j-1];
                } else {
                    maxLengthPalindromePossible[i][j] = Math.max(maxLengthPalindromePossible[i][j-1], maxLengthPalindromePossible[i+1][j]);
                }
            }
        }
        
        return maxLengthPalindromePossible[0][n-1];
    }
}
