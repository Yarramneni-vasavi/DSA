import java.util.Arrays;

class FibonacciNumber{
    public int fib_recur(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fib_recur(n-1) + fib_recur(n-2);
    }
    private int fib_dp_helper(int n, int[] dp) {
        if(dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fib_dp_helper(n-1, dp) + fib_dp_helper(n-2, dp);
    }
    public int fib_dp(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        fib_dp_helper(n, dp);
        return dp[n];
    }
    public int fib_dp_tabulation(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        FibonacciNumber f = new FibonacciNumber();
        int n = 25;
        int result1 = f.fib_recur(n);
        int result2 = f.fib_dp(n);
        int result3 = f.fib_dp_tabulation(n);
        System.out.printf("%d, %d, %d", result1, result2, result3);
    }
}