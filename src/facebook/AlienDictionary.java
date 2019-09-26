package facebook;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        int[] indegree = new int[26];
        Map<Character, Set<Character>> g = new HashMap<>();
        buildGraph(g,words,indegree);
        return bfs(g,indegree);
    }

    private void buildGraph(Map<Character, Set<Character>> g, String[] words, int[] indegree) {
        for(String word : words) {
            for(char c : word.toCharArray()) {
                g.putIfAbsent(c,new HashSet<>());
            }
        }

        for(int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            for(int j = 0; j < len; j++) {
                if(first.charAt(j) != second.charAt(j)) {
                    char out = first.charAt(j);
                    char in = second.charAt(j);
                    if(!g.get(out).contains(in)) {
                        g.get(out).add(in);
                        indegree[in - 'a']++;
                    }
                    break;
                }
            }

        }
    }

    private String bfs(Map<Character, Set<Character>> g, int[] indegree) {
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int totalChars = g.size();
        for(char c : g.keySet()) {
            if(indegree[c - 'a'] == 0) {
                sb.append(c);
                q.add(c);
            }
        }

        while(!q.isEmpty()) {
            char out = q.poll();
            if(g.get(out) == null || g.get(out).size() == 0) continue;
            for(char in : g.get(out)) {
                indegree[in - 'a']--;
                if(indegree[in - 'a'] == 0) {
                    q.offer(in);
                    sb.append(in);
                }
            }
        }

        return sb.length() == totalChars ? sb.toString() : "";
    }
}
