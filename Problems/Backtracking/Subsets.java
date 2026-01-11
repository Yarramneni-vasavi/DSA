import java.util.List;
import java.util.ArrayList;

class Subsets {
    public void allPossibleSubsetsHelper(int[] nums, List<List<Integer>> result, List<Integer> currList, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }
        currList.add(nums[index]);
        allPossibleSubsetsHelper(nums, result, currList, index+1);
        currList.removeLast();
        
        allPossibleSubsetsHelper(nums, result, currList, index+1);
    }
    public List<List<Integer>> allPossibleSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        allPossibleSubsetsHelper(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new Subsets().allPossibleSubsets(new int[]{1, 2, 3});
        res.forEach(x -> System.out.println(x));
    }
}