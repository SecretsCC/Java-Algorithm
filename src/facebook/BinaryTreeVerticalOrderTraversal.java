package facebook;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> dis = new LinkedList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        nodes.add(root);
        dis.add(0);

        int min = 0;
        int max = 0;

        while(!nodes.isEmpty()) {
            TreeNode cur = nodes.poll();
            int curDis = dis.poll();
            if(!map.containsKey(curDis)) map.put(curDis,new ArrayList<>());
            map.get(curDis).add(cur.val);
            if(cur.left != null) {
                nodes.add(cur.left);
                dis.add(curDis - 1);
                if(min > curDis - 1)
                    min = curDis - 1;
            }
            if(cur.right != null) {
                nodes.add(cur.right);
                dis.add(curDis + 1);
                if(max < curDis + 1)
                    max = curDis + 1;
            }
        }
        for(int i = min; i <= max; ++i) {
            res.add(map.get(i));
        }
        return res;
    }
}
