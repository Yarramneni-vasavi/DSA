import java.util.List;
import java.util.ArrayList;

class Permutations {

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void permuteHelper(int[] nums, int index, List<List<Integer>> result) {

        if (index == nums.length) {
            List<Integer> curr = new ArrayList<>();
            for (int num : nums) {
                curr.add(num);
            }
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permuteHelper(nums, index + 1, result);
            swap(nums, index, i);
        }
       
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteHelper(nums, 0, result);
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Permutations().permute(new int[]{1, 2, 3});
        for (List<Integer> list: result) {
            for (Integer x : list) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}