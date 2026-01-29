import java.util.List;
import java.util.ArrayList;

class LongestIncreasingSubsequence {

    private int findRightFit(List<Integer> tails, int curr) {
        // find smallest element greater than current element given
        // using binary seach
        int min = 0;
        int max = tails.size() - 1;

        while (min < max) {
            int mid = (min + max) / 2;
            int midEle = tails.get(mid);
            if (curr <= midEle) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    public int lengthOfLISOpt(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> tails = new ArrayList<>();
        tails.add(nums[0]);

        for (int i=1; i<len; i++) {
            if (nums[i] > tails.getLast()) {
                tails.add(nums[i]);
            } else {
                int idx = findRightFit(tails, nums[i]);
                tails.remove(idx);
                tails.add(idx, nums[i]);
            }
        }
        return tails.size();
    }

    // DP approach - TC = O(n^2)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int result = 0;

        for (int i=0; i<len; i++) {
            int count = 1;
            int max = 1;
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    count = dp[j] + 1;
                    max = Math.max(count, max);
                }
            }
            dp[i] = max;
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] input = new int[]{4, 10, 4, 3, 8, 9};
        System.out.println(lis.lengthOfLISOpt(input));
    }
}