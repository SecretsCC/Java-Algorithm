package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationsSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null) return res;
        Arrays.sort(candidates);
        findCombination(candidates,target,new ArrayList<Integer>(), 0 );
        return res;
    }

    public void findCombination(int[] candidates, int target, List<Integer> list, int start) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 ) return;

        for(int i = start; i < candidates.length; ++i) {
            list.add(candidates[i]);
            findCombination(candidates, target - candidates[i], list,i);
            list.remove(list.size() - 1);
        }
    }
}
