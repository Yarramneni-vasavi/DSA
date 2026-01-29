import java.util.List;
import java.util.ArrayList;

class Combinations {

    private void combineHelper(int n, int k, int index, List<Integer> currList, List<List<Integer>> result) {

        if (index > n) {
            if (currList.size() == k) {
                result.add(new ArrayList<>(currList));
            }
            return;
        }
        if (currList.size() == k) {
            result.add(new ArrayList<>(currList));
            return;
        }

        currList.add(index);
        combineHelper(n, k, index + 1, currList, result);
        currList.removeLast();

        combineHelper(n, k, index + 1, currList, result);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineHelper(n, k, 1, new ArrayList<>(), result);
        return result;
    }
    //1, 2, 3, 4
    public static void main(String[] args) {
        List<List<Integer>> result = new Combinations().combine(4, 2);
        result.forEach((list) -> {
            list.forEach(x -> System.out.print(x));
            System.out.println();
        });
    }
}