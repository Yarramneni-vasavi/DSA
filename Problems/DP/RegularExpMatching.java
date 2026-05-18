class RegularExpMatching {
    public boolean isMatch(String s, String p) {
        int row = p.length();
        int col = s.length();
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;

        for (int i=2; i<=row; i=i+2) {
            if (p.charAt(i-1) == '*') {
                dp[i][0] = dp[i-2][0];
            }
        }

        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                if (s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(i-1) == '*' && (s.charAt(j-1) == p.charAt(i-2) || p.charAt(i-2) == '.')) {
                    dp[i][j] = dp[i-2][j] || dp[i][j-1]; 
                } else if (p.charAt(i-1) == '*' && (s.charAt(j-1) != p.charAt(i-2))) {
                    dp[i][j] = dp[i-2][j];
                }
            }
        }

        return dp[row][col];
    }
}