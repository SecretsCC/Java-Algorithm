package lookupTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; ++i) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> tmp = map.getOrDefault(key,new ArrayList<String>());
            tmp.add(strs[i]);
            map.put(key,tmp);
        }

        for(String c : map.keySet()) {
            res.add(map.get(c));
        }

        return res;

    }
}
