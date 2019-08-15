package Tree;

import java.util.ArrayList;
import java.util.List;

public class combinations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || k > n) {
            return res;
        }
        List<Integer> curr = new ArrayList<>();
        generateCombinations(n, k, 1, curr);
        return res;
    }

    public void generateCombinations(int n, int k,  int start, List<Integer> curr) {
        if(curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = start; i <= n; ++i) {
            curr.add(i);
            generateCombinations(n,k,i+1,curr);
            curr.remove(curr.size() - 1);
        }
    }
}
