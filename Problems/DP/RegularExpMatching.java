class RegularExpMatching {
    public boolean isMatch(String s, String p) {
        int row = p.length();
        int col = s.length();
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;

        for (int i=2; i<=row; i+2) {
            if ((p.charAt(i-1) == '*') && p.charAt(i-2) >= 'a' && p.charAt(i-2) <= 'z') {
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                if (s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(i-1) == '*' && (s.charAt(j-1) == p.charAt(i-2) || p.charAt(i-2) == '.')) {
                    /**
                     * here. && before part is to check x* pattern matches with jth char in string
                     * dp[i-2][j-1] => when x* and curr str char is NOT considered, if there is a match.
                     * dp[i][j-1] -> if x* is considered as NOT empty, is there any existing matching sequence
                     */
                    dp[i][j] = dp[i-2][j-1] || dp[i][j-1]; 
                } else if (p.charAt(i-1) == '*' && (s.charAt(j-1) != p.charAt(i-2))) {
                    dp[i][j] = dp[i-2][j];
                }
            }
        }

        return dp[row][col];
    }
}