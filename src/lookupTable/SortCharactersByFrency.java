package lookupTable;

import java.util.*;

public class SortCharactersByFrency {
    public static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());

        StringBuilder res = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char current = maxHeap.remove();
            for(int i = 0; i < map.get(current); i++) {
                res.append(current);
            }
        }
        return res.toString();

    }

    public static void main(String args[]) {
        String test = "tree";
        System.out.print(frequencySort(test));
    }

}
