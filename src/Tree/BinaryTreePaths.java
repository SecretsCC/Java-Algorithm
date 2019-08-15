package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        findPath(root,"",res);
        return res;
    }

    public void findPath(TreeNode root, String path, List<String> res) {
        if(root != null) {
            path += Integer.toString(root.val);
            if(root.left == null && root.right == null) {
                res.add(path);
            }else {
                path += "->";
                findPath(root.left,path,res);
                findPath(root.right,path,res);
            }
        }
    }
}
