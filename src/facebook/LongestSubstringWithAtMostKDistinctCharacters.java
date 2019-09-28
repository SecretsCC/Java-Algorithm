package facebook;

import java.util.Collections;
import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0 || s.length() == 0 || s == null)
            return 0;

        HashMap<Character,Integer> map = new HashMap<>();
        int slow = 0;
        int fast = 0;
        int res = 1;


        while(fast < s.length()){
            map.put(s.charAt(fast),fast++);
            if(map.size() == k + 1) {
                int delindex = Collections.min(map.values());
                map.remove(s.charAt(delindex));
                slow = delindex + 1;
            }
            res = Math.max(res,fast - slow);

        }
        return res;

    }
}
