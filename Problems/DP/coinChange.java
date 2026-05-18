
public class coinChange {
    public static void main(String[] args) {
        int[] result = new int[]{186,419,83,408};
        int res = new coinChange().tryCoinChange(result, 6249);
        System.out.println(res);
    }

    public int tryCoinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        int INF = amount + 1;
        
        for (int i=0; i<amount+1; i++) {
            dp[0][i] = INF;
        }

        for (int i=1; i<=n; i++) {
            for (int j=0; j<amount+1; j++){
                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else if (coins[i-1] == j) {
                    dp[i][j] = 1;
                } else {
                    int temp_coins_needed = 1 + dp[i][j - coins[i-1]];
                    dp[i][j] = Math.min(dp[i-1][j], temp_coins_needed);
                }
            }
        }        

        return dp[n][amount] >= INF ? -1 : dp[n][amount];
    }
}
