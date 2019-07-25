package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p ) {
        List<Integer> res = new ArrayList<>();

        if(s == null || p == null || s.length() < p.length()) return res;

        int[] freq_p = new int[26];
        for(char c : p.toCharArray()) {
            freq_p[c - 'a']++;
        }

        int slength = s.length();
        int plength = p.length();
        int[] freq_s = new int[26];
        for(int i = 0; i < slength; ++i) {
            if(i >= plength) {
                --freq_s[s.charAt(i - plength) - 'a'];
            }
            ++freq_s[s.charAt(i) - 'a'];
            if(same(freq_p, freq_s)) {
                res.add(i - plength + 1);
            }
        }
        return res;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if(s.length() == 0 || s.length() < p.length() || s == null || p == null) return res;

        int[] freq_p = new int[26];

        for(char c : p.toCharArray()) {
            freq_p[c - 'a']++;
        }

        int[] freq_s = new int[26];
        int left = 0;
        int right = 0;
        while(right < s.length()) {
            freq_s[s.charAt(right) - 'a']++;
            right++;
            if(right - left - 1 >= p.length()) {
                --freq_s[s.charAt(left) - 'a'];
                left++;
            }
            System.out.println(Arrays.toString(freq_p));
            System.out.println(Arrays.toString(freq_s));
            if(same(freq_s,freq_p)) res.add(left);
        }

        return res;

    }

    private static boolean same(int[] a,int[] b) {
        for(int i = 0; i < a.length; ++i) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        String a = "cbaebabacd";
        String b = "abc";
        a = b;
        System.out.print(a);

    }
}
