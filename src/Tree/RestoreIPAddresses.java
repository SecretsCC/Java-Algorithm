package Tree;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static List<String> restoreIPAddress(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0 || s.length() > 12 ) return res;
        StringBuilder sb = new StringBuilder();
        dfs(res, s, sb, 0, 0);
        return res;
    }

    private static void dfs(List<String> res, String s, StringBuilder curr, int field, int index) {
        if(index == s.length() && field == 4) {
            res.add(curr.toString());
            return;
        }

        for(int i = index + 1; i <= s.length(); ++i) {
            if(i - index >= 4 || field >= 4) break;
            if(isValid(s.substring(index,i))) {
                StringBuilder copy = new StringBuilder(curr.toString());
                if(copy.length() != 0) {
                    copy.append(".");
                }
                copy.append(s.substring(index,i));
                dfs(res,s,copy,field + 1, i);
            }
        }
    }

    private static boolean isValid(String s) {
        if(s.charAt(0) == '0' && s.length() == 1) return true;
        return Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 255;
    }
}
