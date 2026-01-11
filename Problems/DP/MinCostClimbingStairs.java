import java.util.Arrays;

class MinCostClimbingStairs {
    public int calculateMinCost_dp_tabulation(int[] cost) {
        int n = cost.length;

        cost = Arrays.copyOf(cost, n + 1);
        cost[n] = 0;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);      

        dp[0] = cost[0];
        dp[1] = Math.min(cost[0] + cost[1], cost[1]);

        for(int i=2; i<=n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().calculateMinCost_dp_tabulation(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }
}