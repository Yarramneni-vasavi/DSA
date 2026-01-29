class WildcardMatching {

    public boolean isMatchOptimized(String s, String p) {
        int col = s.length();
        int row = p.length();

        boolean[] prev = new boolean[col+1];
        prev[0] = true;

        boolean loop = true;

        for (int i=1; i<=row; i++) {
            boolean[] curr = new boolean[col+1];
            if (p.charAt(i-1) == '*' && loop) {
                // becoz star can match empty character also
                curr[0] = true;
            } else {
                loop = false;
            }
            for (int j=1; j<=col; j++) {
                if (s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '?') {
                    curr[j] = prev[j-1];
                } else if (p.charAt(i-1) == '*') {
                    curr[j] = prev[j] || curr[j-1];
                }
            }
            prev = curr;
        }

        return prev[col];
    }

    public boolean isMatch(String s, String p) {
        int col = s.length();
        int row = p.length();

        // TC: O(row * col) -> Giving TLE, need to optimize
        boolean[][] dp = new boolean[row+1][col+1];

        dp[0][0] = true;

        for (int i=1; i<=row; i++) {
            if (p.charAt(i-1) == '*') {
                // becoz star can match empty character also
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for (int i=1; i<=row; i++) {
            for (int j=1; j<=col; j++) {
                if (s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(i-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("adceb", "*a*b"));
    }
}