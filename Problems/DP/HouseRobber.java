import java.util.Arrays;

class HouseRobber {
    // recursive approach
    public int rob_helper(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        dp[index] = nums[index] + rob_helper(nums, index + 2, dp);
        return Math.max(dp[index], rob_helper(nums, index + 1, dp)); // adjacent should not ROB
    }
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        int result = rob_helper(nums, 0, dp);
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 3}));
    }
}