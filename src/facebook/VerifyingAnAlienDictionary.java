package facebook;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); ++i){
            map.put(order.charAt(i),i);
        }

        for(int i = 0; i < words.length - 1; ++i){
            String temp1 = words[i];
            String temp2 = words[i + 1];
            boolean flag = false;
            for(int j = 0; j < Math.min(temp1.length(),temp2.length());++j){
                if(temp1.charAt(j) != temp2.charAt(j)){
                    flag = true;
                    if(map.get(temp1.charAt(j)) > map.get(temp2.charAt(j))){
                        return false;
                    }
                    break;
                }
            }
            if(!flag && temp1.length() > temp2.length()) return false;
        }
        return true;
    }
}
