package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return res;
        List<Integer> curr = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(res,nums,curr,0,visited);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> curr, int index, Set<Integer> set) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; ++i) {
            if(!set.contains(nums[i])) {
                curr.add(nums[i]);
                set.add(nums[i]);
                dfs(res,nums,curr,i,set);
                curr.remove(curr.size() - 1);
                set.remove(nums[i]);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        dfs2(nums, used, list, res);
        return res;
    }

    public void dfs2(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs2(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}
