public class longestPalindormicSubstring {
    public static void main(String[] args) {
        String result = new longestPalindormicSubstring().longestPalindrome("abcaac");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        String result = "";
        for (int i=0, j=0; j<n; i++, j++) {
            dp[i][j] = true;
            result = s.substring(i, j+1);
        }

        boolean isFirstDiagonal = true;
        for (int l=1; l<n; l++) {
            if (l >= 2) {
                isFirstDiagonal = false;
            }
            for (int i=0, j=l; i<n-l && j < n; i++, j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = isFirstDiagonal ? true : dp[i+1][j-1];
                }
                if (dp[i][j] == true) {
                    String temp_result = s.substring(i, j+1);
                    if (temp_result.length() > result.length()) {
                        result = temp_result;
                    }
                }
            }
        }
        
        return result;
    }
}
