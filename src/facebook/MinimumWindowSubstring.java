package facebook;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }
        Map<Character,Integer> wordDict = new HashMap<>();
        for(char c : t.toCharArray()) {
            int tcount = wordDict.getOrDefault(c,0);
            wordDict.put(c,tcount + 1);
        }

        int slow = 0;
        int fast;
        int minLen = Integer.MAX_VALUE;
        int matchCount = 0;
        int index = 0;
        for(fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            Integer count = wordDict.get(ch);
            if(count == null) {
                continue;
            }
            wordDict.put(ch,count - 1);
            if(count - 1 == 0) {
                matchCount++;
            }
            while(matchCount == wordDict.size()) {
                if(fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                char leftmost = s.charAt(slow++);
                Integer leftmostCount = wordDict.get(leftmost);
                if(leftmostCount == null) {
                    continue;
                }
                wordDict.put(leftmost,leftmostCount + 1);
                if(leftmostCount + 1 == 1) {
                    matchCount--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index,index + minLen);
    }
}
