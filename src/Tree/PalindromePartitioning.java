package Tree;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        dfs(res, s, new ArrayList<>(), 0);
        return res;
    }

    public static void dfs(List<List<String>> res, String s, List<String> curr, int index) {
        if(index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index + 1; i < s.length() + 1; ++i) {
            if(isPalindrome(s.substring(index,i))) {
                curr.add(s.substring(index,i));
                dfs(res,s,curr,i);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        if(s.length() == 1) return true;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left < right) {
            if(chars[left++] != chars[right--]) return false;
        }
        return true;
    }

    public static void printList(List<String> curr) {
        for(String s : curr) {
            System.out.println(s);
        }
    }

    public static void printRes(List<List<String>> res) {
        for(List<String> s : res)  {
            printList(s);
        }
    }

    public static void main(String args[]) {
        String s = "aab";
        List<List<String>> list = partition(s);
        printRes(list);
    }
}
