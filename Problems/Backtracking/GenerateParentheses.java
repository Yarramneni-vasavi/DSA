import java.util.List;
import java.util.ArrayList;

class GenerateParentheses {

    private void generateParenHelper(int n, int open, int closed, List<String> currList, List<String> result) {

        if (open == n && closed == n) {
            result.add(String.join("", currList));
            return;
        }
        if (open >= closed) {
            if (open != n) {
                currList.add("(");
                generateParenHelper(n, open + 1, closed, currList, result);
                currList.removeLast();
            }
            currList.add(")");
            generateParenHelper(n, open, closed + 1, currList, result);
            currList.removeLast();
        }

    }

    public List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<String>();
        generateParenHelper(n, 0, 0, new ArrayList<String>(), result);
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new GenerateParentheses().generateParentheses(2);
        result.forEach(x -> System.out.println(x));
    }
}