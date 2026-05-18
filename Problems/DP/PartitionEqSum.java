class PartitionEqSum {
    
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum = sum + nums[i];
        }
            
        if (sum % 2 != 0) {
            return false;
        }
        int sum_needed = sum/2;

        int[][] dp = new int[n][sum_needed+1]; // stores whether dp[j] sum possible with 0toi nums

        for (int i=1; i<sum_needed+1; i++) {
            if (nums[0] == i) {
                dp[0][i] = 1;
            }
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<sum_needed+1; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else if (nums[i] < j) {
                    dp[i][j] = (dp[i-1][j] == 1 || dp[i-1][j - nums[i]] == 1) ? 1 : 0;
                } else {
                    dp[i][j] = 1;
                }
            }
        }
        return (dp[n-1][sum_needed] == 1) ? true : false;
    }

    public static void main(String[] args) {
        PartitionEqSum pe = new PartitionEqSum();
        System.out.println(pe.canPartition(new int[]{2,2,1,1}));
    }
}