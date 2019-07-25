package Array;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(s.length() == 0 || s.length() < t.length()) return "";

        int[] slength = new int[256];
        int[] tlength = new int[256];

        for(char c : t.toCharArray()) {
            tlength[c - 'A']++;
        }

        int left = 0;
        int right = -1;
        int len = s.length() + 1;
        String res = "";

        while(right < s.length()) {
            if(containTest(slength,tlength)) {
                if((right - left + 1 < len)) {
                    len = right - left + 1;
                    res = s.substring(left,left + len);
                }
                slength[s.charAt(left) - 'A']--;
                left++;
            }else {
                right++;
                if(right == s.length()) break;
                slength[s.charAt(right) - 'A']++;
            }
        }
        return res;
    }

    private static boolean containTest(int[] a, int[] b) {
        for(int i = 0; i < b.length; ++i) {
            if(b[i] == 0) continue;
            if(b[i] != 0 && b[i] > a[i]) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String S = "ADOBECODEBANC";
        String T = "ABC";

        System.out.print(minWindow(S,T));
    }
}
