package facebook;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..",".",""));
        for(String str : path.split("/")){
            if(str.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!set.contains(str)) stack.push(str);
        }
        String res = "";

        for(String str : stack) {
            res = "/" + str + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
