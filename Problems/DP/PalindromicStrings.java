class palindromicStrings {
    public static void main(String[] args) {
        int result = new palindromicStrings().countSubstrings("abcaac");
        System.out.println(result);
    }

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int result = 0;
        for (int i=0, j=0; j<n; i++, j++) {
            dp[i][j] = true;
            result = result + 1;
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
                    result = result + 1;
                }
            }
        }
        
        return result;
    }
}
