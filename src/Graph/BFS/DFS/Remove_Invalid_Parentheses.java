package Graph.BFS.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Remove_Invalid_Parentheses {
    public List<String> removeInvalidParentheses(String s) {
        int rml = 0;
        int rmr = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                rml++;
            }else if(s.charAt(i) == ')'){
                if(rml != 0){
                    rml--;
                }else{
                    rmr++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), rml, rmr, 0);
        return new ArrayList<String>(res);
    }

    public void dfs(String s, int cur, Set<String> res, StringBuilder sb, int rml, int rmr, int open){
        if(rml < 0 || rmr < 0 || open < 0){
            return;
        }

        if(cur == s.length()){
            if(rml == 0 && rmr == 0 && open == 0){
                res.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(cur);
        int len = sb.length();

        if(c == '('){
            dfs(s, cur+1, res, sb, rml - 1, rmr, open);
            dfs(s, cur + 1, res, sb.append(c), rml,rmr,open+1);
        }else if(c == ')'){
            dfs(s,cur + 1,res,sb,rml,rmr - 1,open);
            dfs(s, cur + 1, res, sb.append(c), rml, rmr, open - 1);
        }else{
            dfs(s,cur+1,res,sb.append(c),rml,rmr,open);
        }

        sb.setLength(len);

    }
}
